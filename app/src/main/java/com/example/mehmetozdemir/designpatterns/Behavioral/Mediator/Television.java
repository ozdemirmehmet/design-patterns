package com.example.mehmetozdemir.designpatterns.Behavioral.mediator;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Television extends ElectronicDevice{

    public Television(DeviceMediator deviceMediator) {
        super(deviceMediator);
        deviceMediator.addTelevision(this);
    }

    @Override
    public void start() {
        Log.d("Mediator => ", "Television started.");
        deviceMediator.startTelevision();
    }

    @Override
    public void stop() {
        Log.d("Mediator => ", "Television stopped.");
    }
}
