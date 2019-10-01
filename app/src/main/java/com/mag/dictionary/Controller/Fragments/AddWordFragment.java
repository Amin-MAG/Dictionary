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
import com.mag.dictionary.R;

public class AddWordFragment extends DialogFragment {


    private TextInputEditText enWord, faWord;
    private MaterialButton create, cancel;


    public static AddWordFragment newInstance() {

        Bundle args = new Bundle();

        AddWordFragment fragment = new AddWordFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_word, container, false);
    }

    @SuppressLint("ResourceType")
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_add_word, null, false);

        // Title

        String titleText = getString(R.string.add_word);
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

        setEvents();

        return dialog;
    }

    private void findItems(View view) {
        faWord = view.findViewById(R.id.addWordFragment_faText);
        enWord = view.findViewById(R.id.addWordFragment_enText);
        create = view.findViewById(R.id.addTaskFragment_create);
        cancel = view.findViewById(R.id.addTaskFragment_cancel);
    }

    private void setEvents() {

        final Fragment fragment = getTargetFragment();
        final Intent intent = new Intent();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String taskTitle = title.getText().toString();
//                String taskDescription = description.getText().toString();
//                Date taskDate = selectedDate;
//
//                try {
//                    if (taskTitle.equals(Constants.EMPTY_STRING) || taskDescription.equals(Constants.EMPTY_STRING))
//                        throw new EmptyFieldException();
//                    Repository.getInstance(getContext()).addTaskForUser(Global.getOnlineUserID(),new Task(taskTitle, taskDescription, taskDate.getTime(), TaskStatus.TODO));
//                } catch (EmptyFieldException e) {
//                    intent.putExtra(DIALOG_ERROR,e.getMessage() );
//                    intent.putExtra(HAS_ERROR,1 );
//                } finally {
//                    fragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
//                    dismiss();
//                }

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
