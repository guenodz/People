package com.guendouz.people.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.guendouz.people.R;
import com.guendouz.people.databinding.ProfileActivityBinding;
import com.guendouz.people.model.User;
import com.guendouz.people.viewmodel.UserViewModel;

/**
 * This activity shows the user profile and must be instantiated using @getStartIntent method
 */
public class ProfileActivity extends AppCompatActivity {


    public static final String EXTRA_USER =
            "com.guendouz.people.view.activity.ProfileActivity.EXTRA_USER";

    ProfileActivityBinding mProfileActivityBinding;
    User mUser;

    public static Intent getStartIntent(Context context, User user) {
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.putExtra(EXTRA_USER, user);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProfileActivityBinding = DataBindingUtil.setContentView(this, R.layout.profile_activity);
        if (mProfileActivityBinding.toolbar != null) {
            setSupportActionBar(mProfileActivityBinding.toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mUser = getIntent().getParcelableExtra(EXTRA_USER);
        mProfileActivityBinding.setUser(new UserViewModel(this, mUser));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
