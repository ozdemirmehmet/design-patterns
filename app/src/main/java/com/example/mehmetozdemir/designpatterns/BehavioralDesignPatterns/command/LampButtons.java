package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.command;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class LampButtons {

    private LampOpenCommand lampOpenCommand;
    private  LampCloseCommand lampCloseCommand;

    public LampButtons(LampOpenCommand lampOpenCommand, LampCloseCommand lampCloseCommand) {
        this.lampOpenCommand = lampOpenCommand;
        this.lampCloseCommand = lampCloseCommand;
    }

    public void openLamp(){
        lampOpenCommand.run();
    }

    public void closeLamp(){
        lampCloseCommand.run();
    }
}
