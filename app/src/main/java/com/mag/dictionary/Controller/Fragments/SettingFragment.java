package com.mag.dictionary.Controller.Fragments;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {


    public static SettingFragment newInstance() {

        Bundle args = new Bundle();

        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public SettingFragment() {
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}
