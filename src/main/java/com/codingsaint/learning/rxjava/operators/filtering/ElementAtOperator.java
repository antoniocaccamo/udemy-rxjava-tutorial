package com.codingsaint.learning.rxjava.operators.filtering;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author antoniocaccamo on 05/03/2020
 */
public class ElementAtOperator {

    private static final Logger logger = LoggerFactory.getLogger(ElementAtOperator.class);

    private static final List<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        logger.info("Example of {}", ElementAtOperator.class.getSimpleName());

        Observable.range(1, 10)
                .elementAt(4)
                .subscribe(new MaybeObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        logger.info("onSubscribe");
                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        logger.info("onSuccess : {}", integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        logger.error("onError", throwable);
                    }

                    @Override
                    public void onComplete() {
                        logger.info("onComplete");
                    }
                });

        ;
        RxUtils.sleep(10000);
    }

}
