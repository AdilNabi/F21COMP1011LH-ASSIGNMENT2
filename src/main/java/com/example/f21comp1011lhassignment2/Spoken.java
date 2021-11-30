package com.example.f21comp1011lhassignment2;

import com.google.gson.annotations.SerializedName;

public class Spoken {

    @SerializedName("text")
    private String text;

    @SerializedName("audio")
    private String audio;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
