package com.northcoders.tatooine.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Style {

    @SerializedName("id")
    private Long id;

    @SerializedName("styleName")
    private String styleName;


    public Style() {
    }

    public Style(Long id, String styleName) {
        this.id = id;
        this.styleName = styleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
}
