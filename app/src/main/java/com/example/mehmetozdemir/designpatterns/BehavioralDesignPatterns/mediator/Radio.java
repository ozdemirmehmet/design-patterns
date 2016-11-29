package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.mediator;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Radio extends ElectronicDevice {

    public Radio(DeviceMediator deviceMediator) {
        super(deviceMediator);
        deviceMediator.addRadio(this);
    }

    @Override
    public void start() {
        Log.d("Mediator => ", "Radio started.");
        deviceMediator.startRadio();
    }

    @Override
    public void stop() {
        Log.d("Mediator => ", "Radio stopped");
    }
}
