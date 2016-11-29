package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.chainOfResponsibility;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class FunctionA extends Function {

    @Override
    protected void doFunction(String functionData) {
        Log.d("CofR => ", functionData + " verisi A işlevi ile gerçekleştirildi.");
    }
}
