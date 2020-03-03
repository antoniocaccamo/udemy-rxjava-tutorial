package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class FlowableWithoutBackPressure {
    private static final Logger logger = LoggerFactory.getLogger(FlowableWithoutBackPressure.class);



    public static void main(String[] args)  {
        try {
            Observable<Integer> observable = Observable.fromIterable(RxUtils.postiveNumbers(1000000))
                    .repeat()
                    .observeOn(Schedulers.newThread())
                    .subscribeOn(Schedulers.newThread())
                    .doOnNext(integer -> logger.info("emitting : {}", integer));

            observable.subscribe(new DemoObserver());

            RxUtils.sleep(60000);
        } catch (Exception e) {
            logger.error("error occurred", e);
        } finally {
        }
    }
}
