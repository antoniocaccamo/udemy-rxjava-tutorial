package com.codingsaint.learning.rxjava.operators.tranforming;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 05/03/2020
 */
public class BufferOperator {

    private static final Logger logger = LoggerFactory.getLogger(BufferOperator.class);


    public static void main(String[] args) {

        logger.info("Example of {}", BufferOperator.class.getSimpleName());

        Observable.fromIterable(com.codingsaint.learning.rxjava.utils.RxUtils.shapes(10))
                .buffer(3)
                .subscribe(new DemoObserver())
        ;
    }
}
