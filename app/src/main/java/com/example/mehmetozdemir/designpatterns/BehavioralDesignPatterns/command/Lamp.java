package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.command;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Lamp {

    public void openLamp(){
        Log.d("Command => ", "Lamp opened");
    }

    public void closeLamp(){
        Log.d("Command => ", "Lamp closed");
    }
}
