package com.shibam.swapicacheengine.model;




import com.fasterxml.jackson.annotation.JsonProperty;

public class Character {

    @JsonProperty("name")
    private String name;

    @JsonProperty("height")
    private String height;

    @JsonProperty("mass")
    private String mass;

    @JsonProperty("hair_color")
    private String hairColor;

    // Add more attributes as needed

    // Constructors
    public Character() {
    }

    public Character(String name, String height, String mass, String hairColor) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        // Set more attributes as needed
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    // Add more getters and setters as needed

    // toString method for easy debugging
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", hairColor='" + hairColor + '\'' +
                // Include more attributes in the toString method
                '}';
    }
}
