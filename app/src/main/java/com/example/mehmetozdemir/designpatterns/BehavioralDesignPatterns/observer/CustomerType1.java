package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.observer;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class CustomerType1 extends PriceObserver {

    public CustomerType1(String name) {
        super(name);
    }

    @Override
    public void updatePrice(int price, String priceName) {
        Log.d("Observer => ", "Benim adım " + name + " " + priceName + "'in fiyatın " + price + " olduğunu öğrendim.");
    }

}
