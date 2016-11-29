package com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.adapter;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class Customer {

    private String phoneNo;
    private String description;

    public Customer(String phoneNo, String description, String allAddress, String city, String country) {
        this.phoneNo = phoneNo;
        this.description = description;
        this.allAddress = allAddress;
        this.city = city;
        this.country = country;
    }

    public String getDescription() {

        return description;
    }

    private String allAddress;
    private String city;
    private String country;

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAllAddress() {
        return allAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
