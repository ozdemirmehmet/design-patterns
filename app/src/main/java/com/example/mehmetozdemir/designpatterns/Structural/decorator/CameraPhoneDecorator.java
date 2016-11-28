package com.example.mehmetozdemir.designpatterns.Structural.decorator;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class CameraPhoneDecorator extends PhoneDecorator {

    public CameraPhoneDecorator(Phone phone) {
        super(phone);
    }

    @Override
    public void createPhone() {
        decoratedPhone.createPhone();
        addCameraFeature();
    }

    private void addCameraFeature(){
        Log.d("Decorator => ", "Camera feature added!");
    }
}
