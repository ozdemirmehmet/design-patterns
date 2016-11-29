package com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.factoryMethod;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public interface IPictureFormat {
    //Oluşturulacak her bir resim formatı için override edilmesi gereken metotlar
    void createPicture(int widht, int height);
}
