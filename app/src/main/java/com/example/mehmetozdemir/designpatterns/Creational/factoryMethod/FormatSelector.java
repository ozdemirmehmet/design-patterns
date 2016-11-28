package com.example.mehmetozdemir.designpatterns.Creational.factoryMethod;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class FormatSelector {

    //Önceden belirlenen kurala göre format seçimi yapacak factory metot
    public IPictureFormat getFormat(int widht, int height){
        int resolution = widht * height;
        if(resolution > 100)
            return new JpegPictureFormat();
        else
            return new GifPictureFormat();
    }
}
