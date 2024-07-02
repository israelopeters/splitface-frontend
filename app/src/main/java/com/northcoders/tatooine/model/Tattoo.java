package com.northcoders.tatooine.model;

import java.util.List;

public class Tattoo {
    private Long id;
    private String description;
    private String price;
    private Artist artist;
    private List<Style> styles;

    public Tattoo(Long id, String description, String price, Artist artist, List<Style> styles) {
        this.id = id;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
