package com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.facade;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Hdd {

    public String readData(String startAddress, String dataLength){
        Log.d("Facade => ", "Sabit diskin " + startAddress + " başlangıç adresinden " + dataLength + " uzunluğunda bilgi okundu.");
        return "Selamun aleyküm dünya!";
    }
}
