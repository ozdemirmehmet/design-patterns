package com.example.mehmetozdemir.designpatterns.Creational.factoryMethod;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class JpegPictureFormat implements IPictureFormat {
    //Jpeg  resim formatı için override metodu
    @Override
    public void createPicture(int widht, int height) {
        Log.d("Factory Method => ", "Jpeg picture created " + widht + "X" + height);
    }
}
