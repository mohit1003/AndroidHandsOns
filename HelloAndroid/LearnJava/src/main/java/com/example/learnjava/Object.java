package com.example.learnjava;

public class Object {
    protected String manufacturer;
    protected int size;
    protected String type;

    public Object(String manufacturer, int size, String type) {
        this.manufacturer = manufacturer;
        this.size = size;
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
