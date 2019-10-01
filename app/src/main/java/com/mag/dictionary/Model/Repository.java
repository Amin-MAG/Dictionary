package com.mag.dictionary.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    private HashMap<String, String> data;

    public HashMap<String, String> getData() {
        HashMap<String,String> data = new HashMap<>();

        data.put("car", "ماشین");
        data.put("wash", "شستن");
        data.put("buy", "خریدن");
        data.put("sell", "فروختن");
        data.put("cry", "گریه کردن");
        data.put("love", "دوست داشتن");
        data.put("school", "مدرسه");
        data.put("radio", "رادیو");

        return data;
    }
}
