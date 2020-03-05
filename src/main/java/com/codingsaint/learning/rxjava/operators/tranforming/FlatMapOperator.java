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
public class FlatMapOperator {

    private static final Logger logger = LoggerFactory.getLogger(FlatMapOperator.class);


    public static void main(String[] args) {

        logger.info("Example of {}", FlatMapOperator.class.getSimpleName());

        List<Integer> list = RxUtils.postiveNumbers(10);
        Observable.fromIterable(list)
                .flatMap(integer -> twice(integer))
                .subscribe(new DemoObserver())
        ;
    }

    private static Observable twice(Integer integer) {
        return Observable.create(observableEmitter -> {
            if ( ! observableEmitter.isDisposed())
                observableEmitter.onNext(integer * 2);
            else
                observableEmitter.onComplete();
        });
    }
}
