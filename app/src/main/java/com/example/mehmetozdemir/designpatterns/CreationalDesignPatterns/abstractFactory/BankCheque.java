package com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.abstractFactory;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class BankCheque implements IPay {

    @Override
    public void pay(int fee) {
        Log.d("Abstract Factory => ", "Bank cheque fee: " + fee);
    }
}
