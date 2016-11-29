package com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.prototype;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class Picture implements Cloneable{

    private String color;
    private int widht;
    private int height;

    public Picture(String color, int widht, int height) {
        this.color = color;
        this.widht = widht;
        this.height = height;
    }

    public Picture getCopy(){
        try {
            return (Picture)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getColor() {
        return color;
    }

    public int getWidht() {
        return widht;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Picture; Color: " + color + " Widht: " + widht + " Height: " + height;
    }
}
