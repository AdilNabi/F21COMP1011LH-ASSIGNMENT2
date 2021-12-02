package com.example.f21comp1011lhassignment2.Models;

import com.google.gson.annotations.SerializedName;

public class Definition {

    @SerializedName("definition")
    private String definition;

    @SerializedName("example")
    private String example;

    @SerializedName("synonyms")
    private String[] synonyms;

    @SerializedName("antonyms")
    private String[] antonyms;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String[] getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }

    public String[] getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(String[] antonyms) {
        this.antonyms = antonyms;
    }
}
