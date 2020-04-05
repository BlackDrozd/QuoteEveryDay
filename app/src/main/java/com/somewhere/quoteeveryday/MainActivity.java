package com.somewhere.quoteeveryday;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.somewhere.quoteeveryday.models.Quote;
import com.somewhere.quoteeveryday.models.QuoteModel;
import com.somewhere.quoteeveryday.presenters.IPresentersHolder;
import com.somewhere.quoteeveryday.presenters.QuotePresenter;
import com.somewhere.quoteeveryday.views.QuoteView;

public class MainActivity extends Activity implements QuoteView {

    private QuotePresenter mQuotePresenter;
    private TextView quoteTextView;
    private TextView authorTextView;
    QouteApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteTextView = findViewById(R.id.quote);
        authorTextView = findViewById(R.id.author);

        app = ((QouteApplication) getApplication());
        mQuotePresenter = ((IPresentersHolder) app).getPresenter();
        mQuotePresenter = new QuotePresenter(new QuoteModel());
        mQuotePresenter.attachView(this);
        mQuotePresenter.getQuote();
    }

    @Override
    public void showQuote(Quote quote) {
        quoteTextView.setText(quote.getText());
        authorTextView.setText(quote.getAuthor());
    }

    @Override
    public void showError(Throwable e) {
        quoteTextView.setText(e.getMessage());
    }

    @Override
    public void showProgress() {
        quoteTextView.setText("downloading...");
    }

    @Override
    protected void onDestroy() {
        mQuotePresenter.detachView();
        super.onDestroy();
    }
}
