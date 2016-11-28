package com.example.mehmetozdemir.designpatterns.Structural.adapter;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class JobAddress implements Address{

    private String allAddress = "ESENTEPE / ŞİŞLİ";
    private String city = "İSTANBUL";
    private String country = "TÜRKİYE";


    @Override
    public String getAllAddress() {
        return allAddress;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getCountry() {
        return country;
    }
}
