package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.observer;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public abstract class PriceObserver {

    String name;

    public PriceObserver(String name) {
        this.name = name;
    }

    public abstract void updatePrice(int price, String priceName);
}
