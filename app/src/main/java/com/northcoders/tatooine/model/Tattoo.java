package com.northcoders.tatooine.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.northcoders.tatooine.BR;

import java.sql.Timestamp;
import java.util.List;

public class Tattoo extends BaseObservable {
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

    @SerializedName("timePosted")
    private Timestamp timePosted;

    public Tattoo() {
    }

    public Tattoo(Long id, String description, String price, Artist artist, List<Style> styles) {
        this.id = id;
        this.design = description;
        this.price = price;
        this.artist = artist;
        this.styles = styles;
    }

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
        notifyPropertyChanged(BR.styles);
    }

    @Bindable
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
        notifyPropertyChanged(BR.design);
    }

    @Bindable
    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
        notifyPropertyChanged(BR.timeTaken);
    }
}
