package com.guendouz.people.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.guendouz.people.BR;
import com.guendouz.people.R;
import com.guendouz.people.model.User;
import com.guendouz.people.viewmodel.UserViewModel;

import java.util.List;

/**
 * A RecyclerView Adapter for the people list
 */

public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListAdapter.BindingViewHolder> {

    private Context mContext;
    private List<User> mUsers;

    public PeopleListAdapter(Context context, List<User> speakers) {
        mContext = context;
        mUsers = speakers;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil
                .inflate(LayoutInflater
                        .from(parent.getContext()), R.layout.user_item_view, parent, false
                );
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {

        ViewDataBinding viewDataBinding = holder.getViewDataBinding();
        viewDataBinding.setVariable(
                BR.user,
                new UserViewModel(mContext, mUsers.get(position))
        );

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class BindingViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding mViewDataBinding;

        public BindingViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());

            mViewDataBinding = viewDataBinding;
            mViewDataBinding.executePendingBindings();
        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }
    }
}
