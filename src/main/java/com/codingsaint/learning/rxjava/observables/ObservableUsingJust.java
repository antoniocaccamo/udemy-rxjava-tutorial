package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.observers.DemoObserver;
import io.reactivex.Observable;

/**
 * @author antoniocaccamo on 03/03/2020
 */
public class ObservableUsingJust {

    public static void main(String[] args) {
        Observable.just("a" , "b", "c", "d", "e", "f", "g", "h", "i", "j").subscribe( new DemoObserver());
    }
}
