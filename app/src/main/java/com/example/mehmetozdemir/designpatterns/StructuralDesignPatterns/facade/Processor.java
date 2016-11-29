package com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.facade;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Processor {

    public void openProcessor(){
        Log.d("Facade => ", "İşlemci açıldı.");
    }

    public void locateProcessor(String address){
        Log.d("Facade => ", "İşlemci ram' in " + address + " adresine konumlandırıldı.");
    }

    public void runProccesor(){
        Log.d("Facade => ", "İşlemci çalıştırıldı.");
    }
}
