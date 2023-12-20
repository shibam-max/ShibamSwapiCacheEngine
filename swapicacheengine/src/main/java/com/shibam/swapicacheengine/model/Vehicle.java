package com.shibam.swapicacheengine.model;







import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {

    @JsonProperty("name")
    private String name;

    @JsonProperty("model")
    private String model;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("length")
    private String length;

    // Add more attributes as needed

    // Constructors
    public Vehicle() {
    }

    public Vehicle(String name, String model, String manufacturer, String costInCredits, String length) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        // Set more attributes as needed
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

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    // Add more getters and setters as needed

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", costInCredits='" + costInCredits + '\'' +
                ", length='" + length + '\'' +
                // Include more attributes in the toString method
                '}';
    }
}
