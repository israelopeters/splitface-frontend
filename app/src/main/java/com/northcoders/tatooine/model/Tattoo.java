package com.northcoders.tatooine.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tattoo {
    @SerializedName("id")
    private Long id;

    @SerializedName("design")
    private String design;

    @SerializedName("price")
    private String price;

    //Serialized name needs adding when added by backend
    @SerializedName("timeTaken")
    private String timeTaken;

    @SerializedName("artist")
    private Artist artist;

    @SerializedName("styles")
    private List<Style> styles;

    public Tattoo() {
    }

    public Tattoo(Long id, String description, String price, Artist artist, List<Style> styles) {
        this.id = id;
        this.design = description;
        this.price = price;
        this.artist = artist;
        this.styles = styles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }
}
