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
public class WordListFragment extends Fragment {


    public static WordListFragment newInstance() {

        Bundle args = new Bundle();

        WordListFragment fragment = new WordListFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public WordListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_word_list, container, false);
    }

}
