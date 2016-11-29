package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.templateMethod;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class RiceMaker extends Cooker{
    @Override
    protected void prepareMaterial() {
        Log.d("Template Method => ", "Pilav malzemeleri hazırlanıyor...");
    }

    @Override
    protected void cook() {
        Log.d("Template Method => ", "Pilav pişiriliyor...");
    }

    @Override
    protected void serveEat() {
        Log.d("Template Method => ", "Pilav servis ediliyor...");
    }
}
