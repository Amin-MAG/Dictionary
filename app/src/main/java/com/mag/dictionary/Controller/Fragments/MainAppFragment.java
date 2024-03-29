package com.mag.dictionary.Controller.Fragments;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.mag.dictionary.Controller.Adapters.WordListRecycleAdapter;
import com.mag.dictionary.Model.Repository;
import com.mag.dictionary.Model.Word;
import com.mag.dictionary.R;
import com.mag.dictionary.Util.UiUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainAppFragment extends Fragment {

    private static final int REQUEST_CODE_FOR_ADD_WORD = 1001;
    public static final String DIALOG_ERROR = "dialog_error";
    public static final String HAS_ERROR = "has_error";
    private static final int REQUEST_CODE_FOR_EDIT_WORD = 1002;
    private static final String EDIT_WORD_FRAGMENT = "edit_word_fragment";
    private static final String EDIT_WORD = "edit_word";
    private static final String ACTION_STRING = "action_string";
    private static final String DELETE_WORD = "delete_word";

    private RecyclerView wordRecycler;
    private WordListRecycleAdapter adapter;
    private TextInputEditText searchText;
    private LinearLayout mainLayout;

    private MainAppFragmentCallback mainAppFragmentCallback;

    public static MainAppFragment newInstance() {

        Bundle args = new Bundle();

        MainAppFragment fragment = new MainAppFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public MainAppFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof MainAppFragmentCallback) {
            mainAppFragmentCallback = (MainAppFragmentCallback) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

        mainAppFragmentCallback = null;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case REQUEST_CODE_FOR_ADD_WORD:

                if (resultCode == Activity.RESULT_OK) {
                    if (data.getIntExtra(HAS_ERROR, 0) == 1)
                        UiUtil.showSnackbar(mainLayout, data.getStringExtra(DIALOG_ERROR), getResources().getString(R.color.app_red));
                    else {
                        adapter.update();
                        UiUtil.showSnackbar(mainLayout, getResources().getString(R.string.successfully_added), getResources().getString(R.color.app_green_dark));
                    }
                }

                break;

            case REQUEST_CODE_FOR_EDIT_WORD:

                if (resultCode == Activity.RESULT_OK) {

                    if (data.getIntExtra(HAS_ERROR, 0) == 1) {
                        UiUtil.showSnackbar(wordRecycler, data.getStringExtra(DIALOG_ERROR), getResources().getString(R.color.app_red));
                    } else {

                        // Update
                        adapter.update();

                        switch (data.getStringExtra(ACTION_STRING)) {
                            case DELETE_WORD:
                                if (wordRecycler != null)
                                    UiUtil.showSnackbar(wordRecycler, getResources().getString(R.string.successfully_deleted), getResources().getString(R.color.app_green_dark));
                                break;
                            case EDIT_WORD:
                                if (wordRecycler != null)
                                    UiUtil.showSnackbar(wordRecycler, getResources().getString(R.string.successfully_edited), getResources().getString(R.color.app_green_dark));
                                break;
                            default:
                                break;
                        }

                    }

                }
                break;
            default:
                break;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_app, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        wordRecycler = view.findViewById(R.id.mainAppActivity_recycler);
        searchText = view.findViewById(R.id.mainAppFragment_searchText);
        mainLayout = view.findViewById(R.id.mainAppFragment_mainLayout);

        searchText.requestFocus();
        searchText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.update();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });


        adapter = new WordListRecycleAdapter(Repository.getInstance(getContext()).getData(), new WordListRecycleAdapter.WordListCallBack() {
            @Override
            public String getSearchText() {
                return searchText.getText().toString();
            }

            @Override
            public void showEditDialog(Word word) {
                EditWordFragment editWordFragment = EditWordFragment.newInstance(word);
                editWordFragment.setTargetFragment(MainAppFragment.this, REQUEST_CODE_FOR_EDIT_WORD);
                editWordFragment.show(getFragmentManager(), EDIT_WORD_FRAGMENT);
            }

            @Override
            public void updateCount() {
                mainAppFragmentCallback.updateCount();
            }
        });
        wordRecycler.setAdapter(adapter);

    }

    public interface MainAppFragmentCallback {
        void updateCount();
    }

}
