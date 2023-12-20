package com.shibam.swapicacheengine.model;



public class Starship {
    private String name;
    private String model;
    private String manufacturer;

    // Constructors
    public Starship() {
    }

    public Starship(String name, String model, String manufacturer) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "Starship{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
