package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class FlowableWithBackPressure {
    private static final Logger logger = LoggerFactory.getLogger(FlowableWithBackPressure.class);

    private static final int BUFFER_SIZE = 5;

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.fromIterable(RxUtils.postiveNumbers(100000))
                .repeat()
                .observeOn(Schedulers.newThread(), false, BUFFER_SIZE)
                .subscribeOn(Schedulers.newThread())
                .doOnNext(integer -> logger.info("emitting : {}", integer));

        flowable.subscribe(new Subscriber<Integer>() {

            private Subscription subscription;
            private AtomicInteger counter = new AtomicInteger();

            @Override
            public void onSubscribe(Subscription subscription) {
                logger.info("onSubscribe");
                this.subscription = subscription;
                subscription.request(BUFFER_SIZE);
            }

            @Override
            public void onNext(Integer integer) {
                logger.info("onNext : {}", integer);
                RxUtils.sleep(200L);
                if (counter.incrementAndGet() % BUFFER_SIZE == 0){
                    subscription.request(BUFFER_SIZE);
                    logger.info("request [{}] elements", integer);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                logger.error("error occurred", throwable);
            }

            @Override
            public void onComplete() {
                logger.info("onComplete");
            }
        });

        RxUtils.sleep(100000L);
    }
}
