package com.example.mehmetozdemir.designpatterns.Creational.factoryMethod;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class GifPictureFormat implements IPictureFormat {

    //Gif resim formatı için override metodu
    @Override
    public void createPicture(int widht, int height) {
        Log.d("Factory Metehod => ", "Gif picture created " + widht + "X" +  height);
    }
}
