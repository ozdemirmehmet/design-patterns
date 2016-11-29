package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.command;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class LampOpenCommand implements Command {

    private Lamp lamp;

    public LampOpenCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void run() {
        lamp.openLamp();
    }
}
