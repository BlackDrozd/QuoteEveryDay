package com.somewhere.quoteeveryday.presenters;

import com.somewhere.quoteeveryday.models.Quote;
import com.somewhere.quoteeveryday.models.QuoteModel;
import com.somewhere.quoteeveryday.utils.SchedulersHolder;
import com.somewhere.quoteeveryday.views.QuoteView;

public class QuotePresenter extends BasePresenter<QuoteView> {

    QuoteModel mQuoteModel;
    QuoteView mQuoteView;

    SchedulersHolder mSchedulersHolder;

    public QuotePresenter(QuoteModel model) {
        mQuoteModel = model;
        mSchedulersHolder = new SchedulersHolder();
    }

    public void attachView(QuoteView view) {
        mQuoteView = view;
    }

    public void detachView() {
        mQuoteView = null;
    }

    public void getQuote() {

        mQuoteModel.getQuote()
                .subscribeOn(mSchedulersHolder.getIOScheduler())
                .observeOn(mSchedulersHolder.getMainScheduler())
                .subscribe((Quote quote) -> mQuoteView.showQuote(quote),
                        (Throwable e) -> mQuoteView.showError(e));

    }


    public void notifyView() {

        if (mQuoteView == null) return;

    }
}
