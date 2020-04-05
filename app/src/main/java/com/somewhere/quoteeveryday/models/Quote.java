package com.somewhere.quoteeveryday.models;

public class Quote {

    private String mAuthor;

    private String mText;

    public Quote(String author, String text) {
        mAuthor = author;
        mText = text;
    }


    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
