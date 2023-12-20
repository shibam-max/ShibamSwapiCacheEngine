package com.shibam.swapicacheengine.model;





import com.fasterxml.jackson.annotation.JsonProperty;

public class Film {

    @JsonProperty("title")
    private String title;

    @JsonProperty("episode_id")
    private int episodeId;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @JsonProperty("director")
    private String director;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("release_date")
    private String releaseDate;

    // Add more attributes as needed

    // Constructors, getters, and setters

    // toString method for easy debugging

    // Example constructor
    public Film() {
    }

    public Film(String title, int episodeId, String openingCrawl, String director, String producer, String releaseDate) {
        this.title = title;
        this.episodeId = episodeId;
        this.openingCrawl = openingCrawl;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        // Set more attributes as needed
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    // Add more getters and setters as needed

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", episodeId=" + episodeId +
                ", openingCrawl='" + openingCrawl + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                // Include more attributes in the toString method
                '}';
    }
}
