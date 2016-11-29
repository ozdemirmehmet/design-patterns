package com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.facade;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Computer {

    public void openComputer(){

        //Computer sınıfını kullanan class aşağıdaki alt sınıfların çalıştığından(kullanıldığından) haberdar olmaz.
        Processor processor = new Processor();
        Hdd hdd = new Hdd();
        Ram ram = new Ram();


        //Aşağıda yapılan ara işlemlerden Computer sınıfını kullanan class habardar olmaz.
        //Bu işlemler default olarak yapılır.
        //İşlemci açılır.
        processor.openProcessor();
        //Sabit diskten belirli adres ve uzunluktaki veri okunur.
        String readedData = hdd.readData("A12DC3", "1000");
        //Sabit disten okunan veri ram e yazılır.
        ram.loadRam("0012FB", readedData);
        //İşlemci ram de verinin yazıldığı adrese konumlandırılır.
        processor.locateProcessor("0012FB");
        //İşlemci çalıştırılır.
        processor.runProccesor();
    }
}
