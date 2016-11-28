package com.example.mehmetozdemir.designpatterns.Creational.abstractFactory;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public interface IOrder {

    INotification createNotificationStyle();
    IPay createPayStyle();
}
