package com.codingsaint.learning.rxjava.operators.combining;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class ZipOperator {

    private static final Logger logger = LoggerFactory.getLogger(ZipOperator.class);

    public static void main(String[] args) throws InterruptedException {

        logger.info("Example of {}", ZipOperator.class.getSimpleName());

        Observable observable1 = Observable.fromIterable(RxUtils.postiveNumbers(8));
        Observable observable2 = Observable.fromIterable(RxUtils.shapes(6));

        Observable.zip(observable1, observable2, (o1, o2) -> {
                    String result = String.format("o1 [%s] o2 [%s]", o1.toString(), o2.toString());
                    logger.info("result : {}", result);
                    return result;
                })
                .subscribe(new DemoObserver());

     //   RxUtils.sleep(10000);
    }
}
