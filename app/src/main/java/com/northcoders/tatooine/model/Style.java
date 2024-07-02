package com.northcoders.tatooine.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Style {

    private enum StyleEnum{
        WATERCOLOUR,
        REALISM,
        WILDCARD
    }

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private StyleEnum styleName;

    @SerializedName("tattoos")
    List<Tattoo> tattoos;

    public Style() {
    }

    public Style(Long id, StyleEnum styleName, List<Tattoo> tattoos) {
        this.id = id;
        this.styleName = styleName;
        this.tattoos = tattoos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tattoo> getTattoos() {
        return tattoos;
    }

    public void setTattoos(List<Tattoo> tattoos) {
        this.tattoos = tattoos;
    }

    public StyleEnum getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleEnum styleName) {
        this.styleName = styleName;
    }
}
