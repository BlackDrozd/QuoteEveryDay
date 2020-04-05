package com.somewhere.quoteeveryday.utils;

import io.reactivex.rxjava3.core.Scheduler;

public interface ISchedulersHolder {

    Scheduler getIOScheduler();

    Scheduler getMainScheduler();
}
