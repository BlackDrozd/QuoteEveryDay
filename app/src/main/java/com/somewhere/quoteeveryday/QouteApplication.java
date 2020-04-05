package com.somewhere.quoteeveryday;

import android.app.Application;

import com.somewhere.quoteeveryday.models.QuoteModel;
import com.somewhere.quoteeveryday.presenters.IPresentersHolder;
import com.somewhere.quoteeveryday.presenters.QuotePresenter;

public class QouteApplication extends Application implements IPresentersHolder {

    private QuotePresenter mQuotePresenter;

    @Override
    public void onCreate() {
        super.onCreate();
        mQuotePresenter = new QuotePresenter(new QuoteModel());
    }

    public QuotePresenter getPresenter() {
        return mQuotePresenter;
    }
}
