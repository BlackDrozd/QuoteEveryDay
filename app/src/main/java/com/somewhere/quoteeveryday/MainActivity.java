package com.somewhere.quoteeveryday;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements QuoteView {

    QuotePresenter mQuotePresenter;
    TextView quoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteTextView = findViewById(R.id.quote);


        mQuotePresenter = new QuotePresenter(new QuoteModel());
        mQuotePresenter.attachView(this);
        mQuotePresenter.getQuote();
    }

    @Override
    public void showQuote(String quote) {
        quoteTextView.setText(quote);
    }

    @Override
    protected void onDestroy() {
        mQuotePresenter.detachView();
        super.onDestroy();
    }
}
