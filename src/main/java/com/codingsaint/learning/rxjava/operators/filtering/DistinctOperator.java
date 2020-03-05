package com.codingsaint.learning.rxjava.operators.filtering;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author antoniocaccamo on 05/03/2020
 */
public class DistinctOperator {

    private static final Logger logger = LoggerFactory.getLogger(DistinctOperator.class);

    private static final List<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        logger.info("Example of {}", DistinctOperator.class.getSimpleName());

        Observable.just(1, 1, 2, 3, 5, 4, 3, 6, 5, 2)
                .distinct()
                .subscribe(new DemoObserver())
        ;
        RxUtils.sleep(10000);
    }

}
