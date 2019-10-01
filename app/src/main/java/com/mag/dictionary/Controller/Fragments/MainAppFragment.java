package com.mag.dictionary.Controller.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mag.dictionary.Controller.Adapters.WordListRecycleAdapter;
import com.mag.dictionary.Model.BiWord;
import com.mag.dictionary.Model.Repository;
import com.mag.dictionary.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainAppFragment extends Fragment {

    private RecyclerView wordRecycler;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        wordRecycler = view.findViewById(R.id.mainAppActivity_recycler);
        WordListRecycleAdapter adapter =  new WordListRecycleAdapter(Repository.getInstance(getContext()).getData());
        wordRecycler.setAdapter(adapter);

    }


}
