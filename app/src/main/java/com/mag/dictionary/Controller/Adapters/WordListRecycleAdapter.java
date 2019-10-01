package com.mag.dictionary.Controller.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mag.dictionary.Controller.Fragments.WordListFragment;
import com.mag.dictionary.R;

import java.util.HashMap;
import java.util.List;

public class WordListRecycleAdapter extends RecyclerView.Adapter<WordListRecycleAdapter.WordListRecyclerViewHolder> {

    private Activity activity;
    private HashMap<String,String> words;

    public WordListRecycleAdapter(HashMap<String,String> words) {
        this.words = words;
    }

    @NonNull
    @Override
    public WordListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activity = (Activity) parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.layout_word_item, parent, false);
        return new WordListRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class WordListRecyclerViewHolder extends RecyclerView.ViewHolder {

        public WordListRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
