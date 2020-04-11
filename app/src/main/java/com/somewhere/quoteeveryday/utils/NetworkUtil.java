package com.somewhere.quoteeveryday.utils;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.somewhere.quoteeveryday.models.Quote;

import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtil {

    private static final String TAG = "NetworkUtil";

    public static Quote loadQuote() {

        HttpURLConnection connection = null;
        String spec = "https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=ru";

        try {
            connection = (HttpURLConnection) new URL(spec).openConnection();
            connection.setRequestMethod("GET");

            int code = connection.getResponseCode();

            if (code == 200) {
                Log.d(TAG, "status 200");
                Log.d(TAG, connection.getResponseMessage());

                ObjectMapper mapper = new ObjectMapper();
                Quote quote = mapper.readValue(connection.getInputStream(), Quote.class);

                return quote;

            } else if (code == 404) {
                Log.d(TAG, "error: " + connection.getResponseCode());
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return null;
    }
}
