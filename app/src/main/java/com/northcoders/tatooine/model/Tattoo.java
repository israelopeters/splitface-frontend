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
    private String timePosted;

    public Tattoo() {
    }

    public Tattoo(Long id, String price, String design, String hoursWorked, List<Style> styles, String timePosted) {
        this.id = id;
        this.price = price;
        this.design = design;
        this.hoursWorked = hoursWorked;
        this.styles = styles;
        this.timePosted = timePosted;
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
    public String getStyles() {
    StringBuilder styleNames = new StringBuilder();
        for (Style style : styles) {
        if (styleNames.length() > 0) {
            styleNames.append(", ");
        }
        styleNames.append(style.getStyleName());
    }
        return styleNames.toString();
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

    @Bindable
    public String getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(String timePosted) {
        this.timePosted = timePosted;
        notifyPropertyChanged(BR.timePosted);
    }
}
