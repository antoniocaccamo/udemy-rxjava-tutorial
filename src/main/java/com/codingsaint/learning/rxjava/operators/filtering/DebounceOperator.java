package com.codingsaint.learning.rxjava.operators.filtering;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author antoniocaccamo on 05/03/2020
 */
public class DebounceOperator {

    private static final Logger logger = LoggerFactory.getLogger(DebounceOperator.class);

    private static final List<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        logger.info("Example of {}", DebounceOperator.class.getSimpleName());

        Random random = new Random();

        Observable.interval(2, TimeUnit.SECONDS)
            .map( c -> {
                characters.add( (char) (random.nextInt(26) + 'a')  );
                return characters;
            })
            .doOnEach(listNotification -> logger.info("current value : {}", listNotification.getValue()))
            .debounce(1, TimeUnit.SECONDS)
            .observeOn(Schedulers.newThread())
            .observeOn(Schedulers.newThread())
            .subscribe(new DemoObserver())
        ;
        RxUtils.sleep(10000);
    }

}
