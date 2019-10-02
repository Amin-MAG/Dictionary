package com.mag.dictionary.Controller.Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.mag.dictionary.Model.Exceptions.EmptyFieldException;
import com.mag.dictionary.Model.Repository;
import com.mag.dictionary.Model.Word;
import com.mag.dictionary.R;
import com.mag.dictionary.Var.Constants;

public class EditWordFragment extends DialogFragment {

    private static final String ARG_WORD = "arg_word";
    private static final String DIALOG_ERROR = "dialog_error";
    private static final String HAS_ERROR = "has_error";
    private static final String EDIT_WORD = "edit_word";
    private static final String ACTION_STRING = "action_string";
    private static final String DELETE_WORD = "delete_word";


    private TextInputEditText enWord, faWord;
    private MaterialButton edit, cancel, delete;


    private Word selectedWord;

    public static EditWordFragment newInstance(Word word) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_WORD, word);

        EditWordFragment fragment = new EditWordFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectedWord = (Word) getArguments().getSerializable(ARG_WORD);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_word, container, false);
    }

    @SuppressLint("ResourceType")
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_edit_word, null, false);

        // Title

        String titleText = getString(R.string.edit_word);
        ForegroundColorSpan foregroundColorSpanTtile = new ForegroundColorSpan(Color.parseColor(getResources().getString(R.color.white)));
        SpannableStringBuilder titleString = new SpannableStringBuilder(titleText);
        titleString.setSpan(
                foregroundColorSpanTtile,
                0,
                titleText.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );


        // Dialog Box

        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(titleString)
                .setView(view)
                .create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor(getResources().getString(R.color.colorPrimaryDark))));


        findItems(view);

        setText();

        setEvents();

        return dialog;
    }

    private void findItems(View view) {
        edit = view.findViewById(R.id.editTaskFragment_edit);
        cancel = view.findViewById(R.id.editTaskFragment_cancel);
        delete = view.findViewById(R.id.editTaskFragment_delete);
        enWord = view.findViewById(R.id.editWordFragment_enText);
        faWord = view.findViewById(R.id.editWordFragment_faText);
    }

    private void setText() {
        enWord.setText(selectedWord.getEnWord());
        faWord.setText(selectedWord.getFaWord());
    }

    private void setEvents() {


        final Fragment fragment = getTargetFragment();
        final Intent intent = new Intent();

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String enString = enWord.getText().toString();
                String faString = faWord.getText().toString();

                try {
                    if (enString.equals(Constants.EMPTY_STRING) || faString.equals(Constants.EMPTY_STRING))
                        throw new EmptyFieldException();

                    selectedWord.setEnWord(enString);
                    selectedWord.setFaWord(faString);

                    Repository.getInstance(getContext()).updateWord(selectedWord);

                } catch (EmptyFieldException e) {
                    intent.putExtra(DIALOG_ERROR, e.getMessage());
                    intent.putExtra(HAS_ERROR, 1);
                } finally {
                    intent.putExtra(ACTION_STRING, EDIT_WORD);
                    fragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
                    dismiss();
                }

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Repository.getInstance(getContext()).deleteWord(selectedWord.getWordId());
                intent.putExtra(ACTION_STRING, DELETE_WORD);
                intent.putExtra(HAS_ERROR, 0);
                fragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
                dismiss();

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_CANCELED, intent);
                dismiss();

            }
        });
    }

}
