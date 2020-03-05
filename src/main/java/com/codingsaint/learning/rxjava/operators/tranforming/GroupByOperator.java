package com.codingsaint.learning.rxjava.operators.tranforming;

import com.codingsaint.learning.rxjava.models.Shape;
import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 05/03/2020
 */
public class GroupByOperator {

    private static final Logger logger = LoggerFactory.getLogger(GroupByOperator.class);


    public static void main(String[] args) {

        logger.info("Example of {}", GroupByOperator.class.getSimpleName());

        Observable.fromIterable(com.codingsaint.learning.rxjava.utils.RxUtils.shapes(20))
                .groupBy(shape -> shape.getShape())
              //  .observeOn(Schedulers.newThread())
                .subscribe(new Observer<GroupedObservable<String, Shape>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(GroupedObservable<String, Shape> stringShapeGroupedObservable) {
                        logger.info("key : {}", stringShapeGroupedObservable.getKey());
                        stringShapeGroupedObservable.subscribe(new DemoObserver());
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                })
        ;

        RxUtils.sleep(10000);
    }
}
