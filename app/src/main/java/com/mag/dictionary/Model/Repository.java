package com.mag.dictionary.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Repository {

    // Singleton

    private static Repository instance;

    public static Repository getInstance(Context context) {
        if (instance == null)
            instance = new Repository(context);
        return instance;
    }

    // Repository

    private SQLiteDatabase database;
    private Context context;

    private Repository (Context context) {
        this.context = context.getApplicationContext();
    }

    // Word Management

    private ArrayList<BiWord> data;

    public ArrayList<BiWord> getData() {
        data = new ArrayList<>();

        data.add(new BiWord("car", "ماشین"));
        data.add(new BiWord("wash", "شستن"));
        data.add(new BiWord("buy", "خریدن"));
        data.add(new BiWord("sell", "فروختن"));
        data.add(new BiWord("cry", "گریه کردن"));
        data.add(new BiWord("love", "دوست داشتن"));
        data.add(new BiWord("school", "مدرسه"));
        data.add(new BiWord("radio", "رادیو"));

        return data;
    }
}
