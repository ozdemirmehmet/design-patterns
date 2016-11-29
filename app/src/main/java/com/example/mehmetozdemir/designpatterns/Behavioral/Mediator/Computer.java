package com.example.mehmetozdemir.designpatterns.Behavioral.mediator;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Computer extends ElectronicDevice{


    public Computer(DeviceMediator deviceMediator) {
        super(deviceMediator);
        deviceMediator.addComputer(this);
    }

    @Override
    public void start() {
        Log.d("Mediator => ", "Computer started");
        deviceMediator.startComputer();
    }

    @Override
    public void stop() {
        Log.d("Mediator => ", "Computer stopped");
    }
}
