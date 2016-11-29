package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.observer;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public interface Topic {

    void addObserver(PriceObserver priceObserver);
    void giveNoticeObservers();

}
