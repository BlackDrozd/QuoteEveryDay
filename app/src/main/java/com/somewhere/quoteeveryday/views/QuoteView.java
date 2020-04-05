package com.somewhere.quoteeveryday.views;

import com.somewhere.quoteeveryday.models.Quote;

public interface QuoteView {

    void showQuote(Quote quote);

    void showError(Throwable e);

    void showProgress();
}
