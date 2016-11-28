package com.example.mehmetozdemir.designpatterns.Creational.abstractFactory;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class FastOrderSelector implements IOrder {
    @Override
    public INotification createNotificationStyle() {
        return new Sms();
    }

    @Override
    public IPay createPayStyle() {
        return new BankTransfer();
    }
}
