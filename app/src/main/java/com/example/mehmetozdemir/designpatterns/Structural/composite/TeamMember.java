package com.example.mehmetozdemir.designpatterns.Structural.composite;

import android.util.Log;
/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class TeamMember implements Employee{

    private String name;
    private String surname;

    public TeamMember(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public void printData() {
        Log.d("Composite => ", "- Employe; Name: " + getName() + " Surname: " + getSurname());
    }
}
