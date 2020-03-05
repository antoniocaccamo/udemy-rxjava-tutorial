package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class ObservableUsingCreate {

    private static final Logger logger = LoggerFactory.getLogger(ObservableUsingCreate.class);

    public static void main(String[] args) {

        logger.info("Example of {}", ObservableUsingCreate.class.getSimpleName());

        Observable.create(
                new ObservableOnSubscribe<Object>() {
                    @Override
                    public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                        try {
                            RxUtils.shapes(30).stream()
                                    .forEach(shape -> {
                                        logger.info("emitting : {}", shape);
                                        emitter.onNext(shape);
                                    });
                        } catch (Exception e) {
                            logger.error("error occurred", e);
                            emitter.onError(e);
                        } finally {
                            logger.info("finish emitting events");
                            emitter.onComplete();
                        }
                    }
                }
        ).subscribe( new DemoObserver());
    }
}
