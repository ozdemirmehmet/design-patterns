package com.example.mehmetozdemir.designpatterns.Structural.flyweight;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class CharacterCreator {

    private Map<java.lang.Character, Character> characterPool = new HashMap<java.lang.Character, Character>();

    public Character getCharacter(char character){

        //Eğer karakter havuzunda karakter varsa onu döndür.
        if(characterPool.containsKey(character)){
            Log.d("Flyweight => ", "Object: " + character + ", object already has been");
            return characterPool.get(character);
        }

        //Karakter yoksa karakteri karakter havuzuna ekleyip döndür
        Character newCharacter = new Character(character);
        characterPool.put(character, newCharacter);
        Log.d("Flyweight => ", "Object: " + character + ", new object crated");
        return newCharacter;
    }
}
