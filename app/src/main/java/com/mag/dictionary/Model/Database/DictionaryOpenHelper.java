package com.mag.dictionary.Model.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DictionaryOpenHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;

    public DictionaryOpenHelper(@Nullable Context context) {
        super(context, DictionaryDBSchema.NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + DictionaryDBSchema.Word.NAME + "("
                        + DictionaryDBSchema.Word.Cols._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + DictionaryDBSchema.Word.Cols.EN_WORD + ", "
                        + DictionaryDBSchema.Word.Cols.FA_WORD
                        + ");"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
