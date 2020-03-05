package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.models.Shape;
import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class ObservableUsingRange {

    private static final Logger logger = LoggerFactory.getLogger(ObservableUsingRange.class);

    public static void main(String[] args) {

        logger.info("Example of {}", ObservableUsingRange.class.getSimpleName());

        Observable.range(4, 10)
                .subscribe(new DemoObserver());
    }
}
