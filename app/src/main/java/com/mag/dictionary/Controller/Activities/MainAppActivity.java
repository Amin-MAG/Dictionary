package com.mag.dictionary.Controller.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.mag.dictionary.Controller.Fragments.WordListFragment;
import com.mag.dictionary.R;

public class MainAppActivity extends SingleFragmentActivity {

    @Override
    public Fragment getFragment() {
        return WordListFragment.newInstance();
    }

    @Override
    public String getTagName() {
        return "tag_word_list_fragment";
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.layout_app_custom_toolbar);
//        ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.userInfoFragment_username)).setText(Global.getOnlineUsername());




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
