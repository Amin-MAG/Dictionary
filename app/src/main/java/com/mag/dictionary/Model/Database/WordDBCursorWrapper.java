package com.mag.dictionary.Model.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.mag.dictionary.Model.Word;

public class WordDBCursorWrapper extends CursorWrapper {


    public WordDBCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public  Word getWord() {
        int id = getInt(getColumnIndex(DictionaryDBSchema.Word.Cols._ID));
        String enWord = getString(getColumnIndex(DictionaryDBSchema.Word.Cols.EN_WORD));
        String faWord = getString(getColumnIndex(DictionaryDBSchema.Word.Cols.FA_WORD));

        return new Word(id, enWord, faWord);
    }

}
