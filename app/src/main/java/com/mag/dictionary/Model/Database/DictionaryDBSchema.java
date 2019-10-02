package com.mag.dictionary.Model.Database;

public class DictionaryDBSchema {

    public static final String NAME = "dict.db";

    public static class Word {

        public static final String NAME = "word";

        public static class Cols {

            public static final String _ID = "_id";
            public static final String EN_WORD = "en_word";
            public static final String FA_WORD = "fa_word";

        }

    }


}
