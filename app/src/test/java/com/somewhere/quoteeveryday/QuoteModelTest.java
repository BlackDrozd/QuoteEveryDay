package com.somewhere.quoteeveryday;

import com.somewhere.quoteeveryday.models.QuoteModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuoteModelTest {

    QuoteModel mQuoteModel;

    @Before
    public void setUp() throws Exception {
        mQuoteModel = new QuoteModel();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getQuote() {
        assertEquals("Hello", mQuoteModel.getQuote());
    }
}