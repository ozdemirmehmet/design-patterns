package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.chainOfResponsibility;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class FunctionC extends Function{

    @Override
    protected void doFunction(String functionData) {
        Log.d("CofR => ", functionData + " verisi C işlevi ile gerçekleştirildi.");
    }
}
