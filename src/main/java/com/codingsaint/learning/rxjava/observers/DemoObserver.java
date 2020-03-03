package com.codingsaint.learning.rxjava.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class DemoObserver implements Observer<Object> {
    private static final Logger logger = LoggerFactory.getLogger(DemoObserver.class);

    @Override
    public void onSubscribe(Disposable disposable) {
        logger.info("onSubscribe");
    }

    @Override
    public void onNext(Object s) {
        logger.info("onNext : {}", s);
    }

    @Override
    public void onError(Throwable throwable) {
        logger.error("onError : {}", throwable);
    }

    @Override
    public void onComplete() {
        logger.info("onComplete");
    }
}
