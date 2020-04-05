package com.somewhere.quoteeveryday.models;

import java.util.concurrent.Callable;

import io.reactivex.rxjava3.core.Observable;

public class QuoteModel {

    public Observable<Quote> getQuote() {
        return Observable.fromCallable(new HardWorkCallable());
    }

    private class HardWorkCallable implements Callable<Quote> {

        @Override
        public Quote call() throws Exception {
            Thread.sleep(5000);
            return new Quote("Nekto", "Мы и сами с усами");
        }
    }


}
