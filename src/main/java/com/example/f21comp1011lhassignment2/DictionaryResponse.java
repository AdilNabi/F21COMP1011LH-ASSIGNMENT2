package com.example.f21comp1011lhassignment2;

import com.google.gson.annotations.SerializedName;

public class DictionaryResponse {

    @SerializedName("word")
    private String word;

    @SerializedName("phonetic")
    private String phonetic;

    @SerializedName("phonetics")
    private Phonetic[] phonetics;

    @SerializedName("origin")
    private String origin;

    @SerializedName("meanings")
    private Meaning[] meanings;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public Phonetic[] getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(Phonetic[] phonetics) {
        this.phonetics = phonetics;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Meaning[] getMeanings() {
        return meanings;
    }

    public void setMeanings(Meaning[] meanings) {
        this.meanings = meanings;
    }
}
