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
public class AppCustomToolbarFragment extends Fragment {


    public static AppCustomToolbarFragment newInstance() {

        Bundle args = new Bundle();

        AppCustomToolbarFragment fragment = new AppCustomToolbarFragment();
        fragment.setArguments(args);

        return fragment;
    }
    
    public AppCustomToolbarFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_app_custom_toolbar, container, false);
    }

}
