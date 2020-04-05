package com.somewhere.quoteeveryday.utils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SchedulersHolder implements ISchedulersHolder {
    @Override
    public Scheduler getIOScheduler() {
        return Schedulers.io();
    }

    @Override
    public Scheduler getMainScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
