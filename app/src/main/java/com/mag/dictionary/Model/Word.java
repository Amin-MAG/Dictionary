package com.mag.dictionary.Model;

import java.io.Serializable;

public class Word implements Serializable {

    private int wordId;
    private String enWord;
    private String faWord;


    public Word(String enWord, String faWord) {
        this.enWord = enWord;
        this.faWord = faWord;
    }

    public Word(int wordId, String enWord, String faWord) {
        this.wordId = wordId;
        this.enWord = enWord;
        this.faWord = faWord;
    }

    public int getWordId() {
        return wordId;
    }

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public String getFaWord() {
        return faWord;
    }

    public void setFaWord(String faWord) {
        this.faWord = faWord;
    }

}
