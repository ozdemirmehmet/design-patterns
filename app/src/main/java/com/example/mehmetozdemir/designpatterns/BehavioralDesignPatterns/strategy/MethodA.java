package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.strategy;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class MethodA implements DebtCalculationMethod {

    @Override
    public void calculateDebt() {
        Log.d("Strategy => ", "A metodu ile borç hesaplandı.");
    }
}
