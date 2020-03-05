package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class ObservableUsingJust {

    public static final Logger logger = LoggerFactory.getLogger(ObservableUsingJust.class);

    public static void main(String[] args) {

        logger.info("Example of {}", ObservableUsingJust.class.getSimpleName());

        Observable.just("a" , "b", "c", "d", "e", "f", "g", "h", "i", "j")
                .subscribe( new DemoObserver())
        ;
    }
}
