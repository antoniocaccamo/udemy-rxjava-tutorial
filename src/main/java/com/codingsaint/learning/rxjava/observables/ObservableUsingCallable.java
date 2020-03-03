package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class ObservableUsingCallable {

    private static final Logger logger = LoggerFactory.getLogger(ObservableUsingCallable.class);

    public static void main(String[] args) {
        Observable.fromCallable(() ->{

            RxUtils.sleep(3000);
            return "hi";
        })
        .subscribe(new DemoObserver());
    }
}
