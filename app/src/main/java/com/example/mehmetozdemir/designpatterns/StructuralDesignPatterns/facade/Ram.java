package com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.facade;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Ram {

    public void loadRam(String address, String info){
        Log.d("Facade => ", info + " verisi " + "ram' in " + address + " adresine yüklendi");
    }
}
