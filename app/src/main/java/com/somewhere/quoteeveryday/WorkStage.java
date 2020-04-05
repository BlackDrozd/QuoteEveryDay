package com.somewhere.quoteeveryday;

public class WorkStage {

    private final Stage mStage;
    private String mQoute;

    WorkStage(Stage stage, String quote) {
        mStage = stage;
        mQoute = quote;
    }

    WorkStage(Stage stage) {
        this(stage, null);
    }

    public Stage getStage() {
        return mStage;
    }

    public String getQoute(String quote) {
        return quote;
    }

    public enum Stage {

        DOWNLOADING,
        COMPLETED
    }
}
