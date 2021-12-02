package com.example.f21comp1011lhassignment2.Models;

import com.google.gson.annotations.SerializedName;

public class Meaning {

    @SerializedName("partOfSpeech")
    private String partOfSpeech;

    @SerializedName("definitions")
    private Definition[] definitions;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public Definition[] getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Definition[] definitions) {
        this.definitions = definitions;
    }
}
