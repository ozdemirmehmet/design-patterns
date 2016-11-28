package com.example.mehmetozdemir.designpatterns.Creational.singleton;

import android.util.Log;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class TestObject {

    private String name = "Mehmet";
    private String surname = "ÖZDEMİR";


    //Static olarak bir nesne oluşturulur
    private static TestObject testObject = new TestObject();

    //Conctructor' a dışarıdan ulaşılamaz ve sınıftan başka nesneler türetilemez.
    private TestObject(){
        Log.d("Singleton => ","Test Object created");
    }

    //Static olarak tanımlanan nesneye bu metot ile ulaşılabilir.
    public static TestObject getTestObject(){
        return testObject;
    }

    //Nesnenin içindeki değerlere nesne çağırılarak alttaki metotlarla ulaşılabilir.
    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }
}
