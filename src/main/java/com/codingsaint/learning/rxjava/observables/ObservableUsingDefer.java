package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.models.Shape;
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
public class ObservableUsingDefer {

    private static final Logger logger = LoggerFactory.getLogger(ObservableUsingDefer.class);

    public static void main(String[] args) {
        Observable<Shape> defer = Observable.defer(() -> {
            return Observable.fromIterable(RxUtils.shapes(7));
        });

        defer.subscribe(new DemoObserver());

        defer.subscribe(new DemoObserver());
    }
}
