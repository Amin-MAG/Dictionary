package com.mag.dictionary.Controller.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.mag.dictionary.R;
import com.mag.dictionary.Util.UiUtil;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment getFragment();

    public abstract String getTagName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_single_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.singleFragmentActivity_mainFrame);

        if (fragment == null)  UiUtil.changeFragment(fragmentManager, getFragment(),R.id.singleFragmentActivity_mainFrame,false, getTagName());

    }

}
