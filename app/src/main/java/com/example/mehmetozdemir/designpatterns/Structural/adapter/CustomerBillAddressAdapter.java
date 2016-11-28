package com.example.mehmetozdemir.designpatterns.Structural.adapter;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class CustomerBillAddressAdapter implements Address {

    private Customer customer;

    public CustomerBillAddressAdapter(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String getAllAddress() {
        return customer.getAllAddress();
    }

    @Override
    public String getCity() {
        return customer.getCity();
    }

    @Override
    public String getCountry() {
        return customer.getCountry();
    }
}
