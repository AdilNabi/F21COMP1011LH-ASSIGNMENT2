package com.example.f21comp1011lhassignment2;

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
}
