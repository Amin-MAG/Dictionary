package com.mag.dictionary.Model;

public class BiWord {

    private int wordId;
    private String firstWord;
    private String secondWord;


    public BiWord(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    public BiWord(int wordId, String firstWord, String secondWord) {
        this.wordId = wordId;
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    public int getWordId() {
        return wordId;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

}
