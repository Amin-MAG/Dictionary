package com.mag.dictionary.Controller.Activities;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.mag.dictionary.Controller.Fragments.SettingFragment;

public class SettingActivity extends SingleFragmentActivity {

    public static final String TAG_SETTING_FRAGMENT = "tag_Setting_fragment";

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        return intent;
    }

    @Override
    public Fragment getFragment() {
        return SettingFragment.newInstance();
    }

    @Override
    public String getTagName() {
        return TAG_SETTING_FRAGMENT;
    }

}
