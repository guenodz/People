package com.guendouz.people.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.guendouz.people.R;
import com.guendouz.people.databinding.MainActivityBinding;
import com.guendouz.people.view.fragment.PeopleFragment;

public class MainActivity extends AppCompatActivity {

    MainActivityBinding mMainActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        if (mMainActivityBinding.toolbar != null) {
            setSupportActionBar(mMainActivityBinding.toolbar);
            mMainActivityBinding.toolbar.setTitle("People");
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_content, new PeopleFragment())
                .commit();
    }
}
