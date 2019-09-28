package com.mag.dictionary.Controller.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.mag.dictionary.R;

public class MainAppActiviry extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, MainAppActiviry.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app_activiry);
    }
}
