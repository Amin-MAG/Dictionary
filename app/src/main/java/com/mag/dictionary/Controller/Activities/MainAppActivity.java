package com.mag.dictionary.Controller.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import com.mag.dictionary.Controller.Fragments.AddWordFragment;
import com.mag.dictionary.Controller.Fragments.MainAppFragment;
import com.mag.dictionary.Model.Repository;
import com.mag.dictionary.R;

public class MainAppActivity extends SingleFragmentActivity {

    private static final int REQUEST_CODE_FOR_ADD_WORD = 1001;
    private static final String ADD_WORD_FRAGMENT = "add_word_fragment";
    public static final String TAG_MAIN_APP_FRAGMENT = "tag_main_app_fragment";


    @Override
    public Fragment getFragment() {
        return MainAppFragment.newInstance();
    }

    @Override
    public String getTagName() {
        return "tag_main_app_fragment";
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Repository.getInstance(getApplicationContext()).getData();

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.layout_app_custom_toolbar);

        updateToolbarWordCount();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mainMenu_add:

                AddWordFragment addWordFragment = AddWordFragment.newInstance();
                addWordFragment.setTargetFragment(getSupportFragmentManager().findFragmentByTag(TAG_MAIN_APP_FRAGMENT), REQUEST_CODE_FOR_ADD_WORD);

                addWordFragment.show(getSupportFragmentManager(), ADD_WORD_FRAGMENT);
                return true;
            case R.id.mainMenu_exit:

                finish();

                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void updateToolbarWordCount() {
        ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_item_count)).setText(getString(R.string.items, Repository.getInstance(getApplicationContext()).getSize()));
    }

}
