package com.example.learnjava;

public class Phone extends Object{
    String manufacturer;
    String color;
    int size;

    public Phone(String manufacturer, String color, int size) {
        super("Something", 20,  "Phone");
        this.manufacturer = manufacturer;
        this.color = color;
        this.size = size;
    }

//    public Phone(String manufacturer, float size) {
//        this.manufacturer = manufacturer;
//        this.size = size;
//    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size + 1;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
