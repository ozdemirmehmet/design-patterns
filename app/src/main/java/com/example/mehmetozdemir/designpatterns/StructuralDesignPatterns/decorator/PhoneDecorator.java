package com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.decorator;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public abstract class PhoneDecorator implements Phone{

    public Phone decoratedPhone;

    public PhoneDecorator(Phone phone){
        decoratedPhone = phone;
    }
}
