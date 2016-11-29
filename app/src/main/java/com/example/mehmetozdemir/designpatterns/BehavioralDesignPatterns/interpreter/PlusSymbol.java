package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.interpreter;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class PlusSymbol implements Symbol {

    @Override
    public void interpretSymbol() {
        Log.d("Interpreter => ", "+ sembolü yorumlandı.");
    }
}
