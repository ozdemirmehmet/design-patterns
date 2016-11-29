package com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.flyweight;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class Character {

    private char character;

    public Character(char character) {
        this.character = character;
    }

    public void printChar(){
        Log.d("Flyweight => ", "Ekrana basılan karakter: " + character);
    }
}
