package com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.abstractFactory;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class NormalOrderSelector implements IOrder{
    @Override
    public INotification createNotificationStyle() {
        return new Email();
    }

    @Override
    public IPay createPayStyle() {
        return new BankCheque();
    }
}
