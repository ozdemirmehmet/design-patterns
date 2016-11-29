package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.mediator;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class DeviceMediator {

    private Computer computer;
    private Television television;
    private Radio radio;

    public void addComputer(Computer computer){
        this.computer = computer;
    }

    public void addTelevision(Television television){
        this.television = television;
    }

    public void addRadio(Radio radio){
        this.radio = radio;
    }

    public void startComputer(){
        //Bilgisayar açıldığında diğer elektronik cihazlar kapatılacak
        television.stop();
        radio.stop();
    }

    public void startTelevision(){
        //Televizyon açıldığında diğer elektronik cihazlar kapatılacak.
        computer.stop();
        radio.stop();
    }

    public void startRadio(){
        //Radyo açıldığında diğer elektronik cihazlar kapatılacak
        computer.stop();
        television.stop();
    }
}
