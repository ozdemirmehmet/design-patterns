package com.example.mehmetozdemir.designpatterns.Behavioral.mediator;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public abstract class ElectronicDevice {

    protected DeviceMediator deviceMediator;

    public ElectronicDevice(DeviceMediator deviceMediator) {
        this.deviceMediator = deviceMediator;
    }

    public abstract void start();

    public abstract void stop();

}
