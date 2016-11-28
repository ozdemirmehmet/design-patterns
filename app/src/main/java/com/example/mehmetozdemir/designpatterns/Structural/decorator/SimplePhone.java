package com.example.mehmetozdemir.designpatterns.Structural.decorator;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class SimplePhone implements Phone {

    @Override
    public void createPhone() {
        Log.d("Decorator => ","Simple phone created!");
    }
}
