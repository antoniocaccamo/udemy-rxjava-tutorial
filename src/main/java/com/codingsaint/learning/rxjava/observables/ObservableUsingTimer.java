package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class ObservableUsingTimer {

    private static final Logger logger = LoggerFactory.getLogger(ObservableUsingTimer.class);

    public static void main(String[] args) throws InterruptedException {
       Observable.timer(200, TimeUnit.MILLISECONDS)
               .subscribe(new DemoObserver());
       RxUtils.sleep(1000);
    }
}
