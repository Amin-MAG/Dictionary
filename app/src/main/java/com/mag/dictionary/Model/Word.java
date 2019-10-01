package com.mag.dictionary.Model;

public class Word {

    private int wordId;
    private String word;


    public Word(int wordId, String word) {
        this.wordId = wordId;
        this.word = word;
    }

    public int getWordId() {
        return wordId;
    }

    public String getWord() {
        return word;
    }

    public void setFirstWord(String firstWord) {
        this.word = firstWord;
    }

}
