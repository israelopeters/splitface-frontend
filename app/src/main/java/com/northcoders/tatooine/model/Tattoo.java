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
    @SerializedName("hoursWorked")
    private String hoursWorked;


    @SerializedName("styles")
    private List<Style> styles;

    @SerializedName("timePosted")
    private Timestamp timePosted;

    public Tattoo() {
    }

    public Tattoo(Long id, String description, String price, List<Style> styles, String hoursWorked) {
        this.id = id;
        this.design = description;
        this.price = price;
        this.styles = styles;
        this.hoursWorked = hoursWorked;
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
    public String getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(String hoursWorked) {
        this.hoursWorked = hoursWorked;
        notifyPropertyChanged(BR.hoursWorked);
    }
}
