package com.codingsaint.learning.rxjava.operators.combining;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class CombiningLastOperator {

    private static final Logger logger = LoggerFactory.getLogger(CombiningLastOperator.class);

    public static void main(String[] args) throws InterruptedException {

        logger.info("Example of {}", CombiningLastOperator.class.getSimpleName());

        Observable observable1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable observable2 = Observable.interval(2, TimeUnit.SECONDS);

        Observable.combineLatest(observable1, observable2, (o1, o2) -> {
                    String result = String.format("o1 [%s] o2 [%s]", o1.toString(), o2.toString());
                    logger.info("result : {}", result);
                    return result;
                })
                .take(10)
                .subscribe(new DemoObserver());

        RxUtils.sleep(10000);
    }
}
