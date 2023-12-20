package com.shibam.swapicacheengine.model;





import com.fasterxml.jackson.annotation.JsonProperty;



public class Species {

    @JsonProperty("name")
    private String name;

    @JsonProperty("classification")
    private String classification;

    @JsonProperty("designation")
    private String designation;

    @JsonProperty("average_height")
    private String averageHeight;

    @JsonProperty("skin_colors")
    private String skinColors;

    // Add more attributes as needed

    // Constructors, getters, and setters

    // toString method for easy debugging

    // Example constructor
    public Species() {
    }

    public Species(String name, String classification, String designation, String averageHeight, String skinColors) {
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.averageHeight = averageHeight;
        this.skinColors = skinColors;
        // Set more attributes as needed
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
    }

    // Add more getters and setters as needed

    @Override
    public String toString() {
        return "Species{" +
                "name='" + name + '\'' +
                ", classification='" + classification + '\'' +
                ", designation='" + designation + '\'' +
                ", averageHeight='" + averageHeight + '\'' +
                ", skinColors='" + skinColors + '\'' +
                // Include more attributes in the toString method
                '}';
    }
}
