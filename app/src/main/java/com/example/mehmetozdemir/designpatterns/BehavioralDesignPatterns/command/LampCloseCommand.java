package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.command;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class LampCloseCommand implements Command {

    private Lamp lamp;

    public LampCloseCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void run() {
        lamp.closeLamp();
    }
}
