package com.example.mehmetozdemir.designpatterns.Creational.abstractFactory;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class Sms implements INotification {

    @Override
    public void sendMessage(String message) {
        Log.d("Abstract Factory => ", "Sms message: " + message);
    }
}
