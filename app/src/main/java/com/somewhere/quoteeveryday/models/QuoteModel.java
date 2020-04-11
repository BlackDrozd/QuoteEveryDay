package com.somewhere.quoteeveryday.models;

import com.somewhere.quoteeveryday.utils.NetworkUtil;

import io.reactivex.rxjava3.core.Observable;

public class QuoteModel {

    public Observable<Quote> getQuote() {
        return Observable.fromCallable(() -> NetworkUtil.loadQuote());
    }


}
