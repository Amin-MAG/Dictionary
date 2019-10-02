package com.mag.dictionary.Controller.Adapters;

import android.app.Activity;
import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mag.dictionary.Controller.Activities.MainAppActivity;
import com.mag.dictionary.Model.Repository;
import com.mag.dictionary.Model.Word;
import com.mag.dictionary.R;

import java.util.List;

public class WordListRecycleAdapter extends RecyclerView.Adapter<WordListRecycleAdapter.WordListRecyclerViewHolder> {

    private Activity activity;
    private List<Word> words;
    private WordListCallBack callBack;

    public WordListRecycleAdapter(List<Word> words, WordListCallBack callBack) {
        this.words = words;
        this.callBack = callBack;
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
        Word word = words.get(position);
        holder.bind(word);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void update() {
        String searchText = callBack.getSearchText();
        if (searchText.length() >= 1) {
            words = Repository.getInstance(activity).getData(searchText);
        } else {
            words = Repository.getInstance(activity).getData();
        }
        notifyDataSetChanged();
        ((MainAppActivity) activity).updateToolbarWordCount();
    }


    public class WordListRecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView wordText, translatedWordText;

        public WordListRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            wordText = itemView.findViewById(R.id.wordItemLayout_word);
            translatedWordText = itemView.findViewById(R.id.wordItemLayout_translated);

        }

        protected void bind(final Word word) {
            wordText.setText(word.getEnWord());
            translatedWordText.setText(word.getFaWord());
        }

    }

    public interface WordListCallBack {
        String getSearchText();
    }

}
