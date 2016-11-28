package com.guendouz.people.view.fragment;


import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guendouz.people.R;
import com.guendouz.people.api.RandomUserAPI;
import com.guendouz.people.api.model.RandomUserResponse;
import com.guendouz.people.databinding.PeopleFragmentBinding;
import com.guendouz.people.view.adapter.PeopleListAdapter;
import com.guendouz.people.view.widget.DividerItemDecoration;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * This fragment contains a RecyclerView to show the list of users
 */
public class PeopleFragment extends Fragment {

    PeopleFragmentBinding mPeopleFragmentBinding;
    PeopleListAdapter mPeopleListAdapter;

    private boolean mIsTabletLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mPeopleFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.people_fragment, container, false);
        mIsTabletLayout = false;
        return mPeopleFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RandomUserAPI randomUserAPI = RandomUserAPI.Factory.create();
        randomUserAPI.getRandomUsers(20)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RandomUserResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("People", e.getMessage());
                    }

                    @Override
                    public void onNext(RandomUserResponse response) {
                        mPeopleFragmentBinding.rvPeopleList.setLayoutManager(setLayoutManager());
                        mPeopleFragmentBinding.rvPeopleList.setHasFixedSize(true);
                        mPeopleListAdapter = new PeopleListAdapter(getContext(), response.getResults());
                        mPeopleFragmentBinding.rvPeopleList.setAdapter(mPeopleListAdapter);
                    }
                });
    }

    private RecyclerView.LayoutManager setLayoutManager() {
        RecyclerView.LayoutManager layoutManager;
        if (!mIsTabletLayout) {
            layoutManager = new LinearLayoutManager(getActivity());
            Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.divider_drawable);
            mPeopleFragmentBinding.rvPeopleList.addItemDecoration(new DividerItemDecoration(dividerDrawable));

        } else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return 1;
                }
            });
            layoutManager = gridLayoutManager;
        }
        return layoutManager;
    }
}
