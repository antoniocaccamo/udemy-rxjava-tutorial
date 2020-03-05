package com.codingsaint.learning.rxjava.operators.filtering;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author antoniocaccamo on 05/03/2020
 */
public class TakeOperator {

    private static final Logger logger = LoggerFactory.getLogger(TakeOperator.class);

    private static final List<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        logger.info("Example of {}", TakeOperator.class.getSimpleName());

        Observable.range(1, 10)
                .take(4)
                .subscribe(new DemoObserver())
        ;
        RxUtils.sleep(10000);
    }

}
