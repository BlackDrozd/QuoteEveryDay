package com.somewhere.quoteeveryday;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class QuotePresenterTest {

    @Mock
    private QuoteView mQuoteView;

    @Mock
    private QuoteModel mQuoteModel;

    private QuotePresenter mQuotePresenter;

    MockitoSession session;

    @Before
    public void before() {
        session = Mockito.mockitoSession()
                .initMocks(this)
                .startMocking();

        mQuoteView = mock(MainActivity.class);

        mQuotePresenter = new QuotePresenter(mQuoteModel);
        mQuotePresenter.attachView(mQuoteView);
        assertNotNull(mQuotePresenter);
    }

    @Test
    public void getQuoteCalled() {
        mQuotePresenter.getQuote();
        //verify(mQuoteView).showQuote("Hello");
    }

    @Test
    public void detachView() {
        mQuotePresenter.detachView();
    }

    @After
    public void after() {
        session.finishMocking();
    }

}