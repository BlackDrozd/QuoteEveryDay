package com.somewhere.quoteeveryday;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private Button getQuoteButton;

    QouteApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteTextView = findViewById(R.id.quote);
        authorTextView = findViewById(R.id.author);
        getQuoteButton = findViewById(R.id.getQuote);

        app = ((QouteApplication) getApplication());
        mQuotePresenter = ((IPresentersHolder) app).getPresenter();
        mQuotePresenter = new QuotePresenter(new QuoteModel());
        mQuotePresenter.attachView(this);
        mQuotePresenter.getQuote();

        getQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuotePresenter.getQuote();
            }
        });


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
