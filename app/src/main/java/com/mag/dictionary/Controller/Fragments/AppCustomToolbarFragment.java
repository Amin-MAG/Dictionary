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


    public AppCustomToolbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_custom_toolbar, container, false);
    }

}
