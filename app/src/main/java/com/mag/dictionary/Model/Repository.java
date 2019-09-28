package com.mag.dictionary.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    //

}
