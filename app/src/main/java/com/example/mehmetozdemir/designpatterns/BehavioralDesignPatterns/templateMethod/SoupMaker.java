package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.templateMethod;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class SoupMaker extends Cooker {

    @Override
    protected void prepareMaterial() {
        Log.d("Template Method => ", "Çorba malzemeleri hazırlanıyor...");
    }

    @Override
    protected void cook() {
        Log.d("Template Method => ", "Çorba pişiriliyor...");
    }

    @Override
    protected void serveEat() {
        Log.d("Template Method => ", "Çorba servis ediliyor...");
    }
}
