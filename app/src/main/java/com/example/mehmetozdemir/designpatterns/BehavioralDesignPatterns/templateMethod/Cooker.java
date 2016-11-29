package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.templateMethod;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public abstract class Cooker {

    public void makeEat(){
        prepareMaterial();
        cook();
        serveEat();
    }

    protected abstract void prepareMaterial();

    protected abstract void cook();

    protected abstract void serveEat();
}
