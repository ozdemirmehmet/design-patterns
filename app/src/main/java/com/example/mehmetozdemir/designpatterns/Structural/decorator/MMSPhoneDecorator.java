package com.example.mehmetozdemir.designpatterns.Structural.decorator;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class MMSPhoneDecorator extends PhoneDecorator {


    public MMSPhoneDecorator(Phone phone) {
        super(phone);
    }

    @Override
    public void createPhone() {
        decoratedPhone.createPhone();
        addMmsFeature();
    }

    private void addMmsFeature(){
        Log.d("Decorator => ", "Mms feature added!");
    }
}
