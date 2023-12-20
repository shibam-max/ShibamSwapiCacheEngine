package com.shibam.swapicacheengine.model;




import com.fasterxml.jackson.annotation.JsonProperty;



public class Planet {

    @JsonProperty("name")
    private String name;

    @JsonProperty("rotation_period")
    private String rotationPeriod;

    @JsonProperty("orbital_period")
    private String orbitalPeriod;

    @JsonProperty("diameter")
    private String diameter;

    @JsonProperty("climate")
    private String climate;

    // Add more attributes as needed

    // Constructors, getters, and setters

    // toString method for easy debugging

    // Example constructor
    public Planet() {
    }

    public Planet(String name, String rotationPeriod, String orbitalPeriod, String diameter, String climate) {
        this.name = name;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.diameter = diameter;
        this.climate = climate;
        // Set more attributes as needed
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }
}
    // Add more getters
