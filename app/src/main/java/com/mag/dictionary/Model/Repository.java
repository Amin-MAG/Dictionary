package com.mag.dictionary.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mag.dictionary.Model.Database.DictionaryDBSchema;
import com.mag.dictionary.Model.Database.DictionaryOpenHelper;
import com.mag.dictionary.Model.Database.WordDBCursorWrapper;

import java.util.ArrayList;

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

    private Repository(Context context) {
        this.database = new DictionaryOpenHelper(context).getWritableDatabase();
        this.context = context.getApplicationContext();
    }

    // Word Management

    private ArrayList<Word> data;
    private int size;

    public void insertWord(Word word) {

        database.insertOrThrow(DictionaryDBSchema.Word.NAME, null, getContentValues(word));

    }


    public void updateTaskForUser(Word selectedWord) {
        database.update(DictionaryDBSchema.Word.NAME, getContentValues(selectedWord), DictionaryDBSchema.Word.Cols._ID + " = ?", new String[]{String.valueOf(selectedWord.getWordId())});
    }

    public ArrayList<Word> getData(String searchText) {
        data = new ArrayList<>();

        Cursor cursor = database.query(DictionaryDBSchema.Word.NAME, null,
                DictionaryDBSchema.Word.Cols.EN_WORD + " LIKE \"" + searchText + "%\" OR " + DictionaryDBSchema.Word.Cols.FA_WORD + " LIKE \"" + searchText + "%\"",
                null, null, null, null);
        WordDBCursorWrapper cursorWrapper = new WordDBCursorWrapper(cursor);

        Log.d("SpecialLog", DictionaryDBSchema.Word.Cols.EN_WORD + " LIKE \"%" + searchText + "\" OR " + DictionaryDBSchema.Word.Cols.FA_WORD + " LIKE \"%" + searchText + "%\"");

        try {

            cursorWrapper.moveToFirst();

            while (!cursorWrapper.isAfterLast()) {

                data.add((cursorWrapper).getWord());
                cursor.moveToNext();

            }

        } finally {

            cursor.close();
            cursorWrapper.close();

        }

        return data;
    }


    public ArrayList<Word> getData() {
        data = new ArrayList<>();

        Cursor cursor = database.query(DictionaryDBSchema.Word.NAME, null, null, null, null, null, null);
        WordDBCursorWrapper cursorWrapper = new WordDBCursorWrapper(cursor);

        try {

            cursorWrapper.moveToFirst();

            while (!cursorWrapper.isAfterLast()) {

                data.add((cursorWrapper).getWord());
                cursor.moveToNext();

            }

        } finally {

            cursor.close();
            cursorWrapper.close();

        }

        size = data.size();

        return data;
    }

    public int getSize() {
        return size;
    }

    private ContentValues getContentValues(Word word) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DictionaryDBSchema.Word.Cols.EN_WORD, word.getEnWord());
        contentValues.put(DictionaryDBSchema.Word.Cols.FA_WORD, word.getFaWord());

        return contentValues;
    }

}
