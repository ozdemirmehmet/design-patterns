package com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.builder;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class Computer {
    
    private String HDD;
    private String RAM;
    
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public Computer(ComputerBuilder computerBuilder) {
        this.HDD = computerBuilder.HDD;
        this.RAM = computerBuilder.RAM;
        this.isGraphicsCardEnabled = computerBuilder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = computerBuilder.isBluetoothEnable;
    }

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }
    
    public static class ComputerBuilder{
        
        private String HDD;
        private String RAM;
        
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnable;
        
        public ComputerBuilder(String HDD, String RAM){
            this.HDD = HDD;
            this.RAM = RAM;
        }
        
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled){
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }
        
        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnable){
            this.isBluetoothEnable = isBluetoothEnable;
            return this;
        }
        
        public Computer build(){
            return new Computer(this);
        }
    }
}
