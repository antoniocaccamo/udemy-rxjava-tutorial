package com.codingsaint.learning.rxjava.operators.tranforming;

import com.codingsaint.learning.rxjava.models.Shape;
import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.GroupedObservable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 05/03/2020
 */
public class MapOperator {

    private static final Logger logger = LoggerFactory.getLogger(MapOperator.class);


    public static void main(String[] args) {

        logger.info("Example of {}", MapOperator.class.getSimpleName());

        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .map(integer -> integer * 2)
                .subscribe(new DemoObserver())
        ;
    }
}
