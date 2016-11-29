package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.strategy;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class MethodB implements DebtCalculationMethod {

    @Override
    public void calculateDebt() {
        Log.d("Strategy => ", "B metodu ile borç hesaplandı.") ;
    }
}
