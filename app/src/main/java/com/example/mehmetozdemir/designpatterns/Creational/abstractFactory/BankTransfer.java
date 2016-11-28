package com.example.mehmetozdemir.designpatterns.Creational.abstractFactory;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class BankTransfer implements IPay {

    @Override
    public void pay(int fee) {
        Log.d("Abstract Factory => ", "Bank transfer fee: " + fee);
    }
}
