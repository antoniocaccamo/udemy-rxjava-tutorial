package com.codingsaint.learning.rxjava.operators.tranforming;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author antoniocaccamo on 05/03/2020
 */
public class ScanOperator {

    private static final Logger logger = LoggerFactory.getLogger(ScanOperator.class);


    public static void main(String[] args) {

        logger.info("Example of {}", ScanOperator.class.getSimpleName());

        List<Integer> list = RxUtils.postiveNumbers(10);

        Observable.fromIterable(list)
                .scan((integer1, integer2) -> {
                    logger.info("integer1 {} integer2 {}", integer1, integer2);
                    return integer1 + integer2;
                })
                .subscribe(new DemoObserver())
        ;
    }

}
