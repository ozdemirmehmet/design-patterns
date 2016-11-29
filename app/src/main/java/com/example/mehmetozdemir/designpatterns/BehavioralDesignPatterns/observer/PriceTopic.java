package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.observer;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class PriceTopic implements Topic{

    private List<PriceObserver> observers = new ArrayList<>();
    private String priceName;
    private int price;

    public PriceTopic(String priceName) {
        this.priceName = priceName;
    }

    @Override
    public void addObserver(PriceObserver priceObserver) {
        observers.add(priceObserver);
        Log.d("Observer => ", priceName + " konusuna " + priceObserver.name + " eklendi");
    }

    @Override
    public void giveNoticeObservers() {
        for (PriceObserver priceObserver : observers){
            priceObserver.updatePrice(price, priceName);
        }
    }

    public void changePrice(int price){
        this.price = price;
        giveNoticeObservers();
    }
}
