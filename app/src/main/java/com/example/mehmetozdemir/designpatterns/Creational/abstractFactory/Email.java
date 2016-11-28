package com.example.mehmetozdemir.designpatterns.Creational.abstractFactory;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class Email implements  INotification{

    @Override
    public void sendMessage(String message) {
        Log.d("Abstarct Factory => ", "Email message: " + message);
    }
}