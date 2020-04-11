package com.somewhere.quoteeveryday.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    @Nullable
    private String mAuthor;

    @NonNull
    private String mText;

    @JsonGetter("quoteAuthor")
    public String getAuthor() {
        return mAuthor;
    }

    @JsonSetter("quoteAuthor")
    public void setAuthor(String author) {
        mAuthor = author;
    }

    @JsonGetter("quoteText")
    public String getText() {
        return mText;
    }

    @JsonSetter("quoteText")
    public void setText(String text) {
        mText = text;
    }

    @NonNull
    @Override
    public String toString() {
        return "Quote {"
                + "author : " + mAuthor + " ,"
                + "text :" + mText + "}";
    }
}
