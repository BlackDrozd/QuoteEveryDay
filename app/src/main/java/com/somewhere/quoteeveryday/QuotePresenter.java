package com.somewhere.quoteeveryday;

import android.view.View;

public class QuotePresenter {

    QuoteModel mQuoteModel;
    QuoteView mQuoteView;

    public QuotePresenter(QuoteModel model) {
        mQuoteModel = model;
    }

    public void attachView(QuoteView view) {
        mQuoteView = view;
    }

    public void detachView() {
        mQuoteView = null;
    }

    public void getQuote() {
        mQuoteView.showQuote(mQuoteModel.getQuote());
    }
}
