package com.mag.dictionary.Controller.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mag.dictionary.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainAppFragment extends Fragment {

    public static MainAppFragment newInstance() {

        Bundle args = new Bundle();

        MainAppFragment fragment = new MainAppFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public MainAppFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_app, container, false);
    }

}
