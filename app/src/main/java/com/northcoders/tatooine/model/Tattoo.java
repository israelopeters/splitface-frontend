package com.northcoders.tatooine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.northcoders.tatooine.BR;

import java.util.List;

public class Tattoo extends BaseObservable implements Parcelable {
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

    protected Tattoo(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        design = in.readString();
        price = in.readString();
        hoursWorked = in.readString();
        timePosted = in.readString();
    }

    public static final Creator<Tattoo> CREATOR = new Creator<Tattoo>() {
        @Override
        public Tattoo createFromParcel(Parcel in) {
            return new Tattoo(in);
        }

        @Override
        public Tattoo[] newArray(int size) {
            return new Tattoo[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(design);
        dest.writeString(price);
        dest.writeString(hoursWorked);
        dest.writeString(timePosted);
    }

    public static class Style extends BaseObservable implements Parcelable {

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

        protected Style(Parcel in) {
            if (in.readByte() == 0) {
                id = null;
            } else {
                id = in.readLong();
            }
            styleName = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            if (id == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeLong(id);
            }
            dest.writeString(styleName);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Style> CREATOR = new Creator<Style>() {
            @Override
            public Style createFromParcel(Parcel in) {
                return new Style(in);
            }

            @Override
            public Style[] newArray(int size) {
                return new Style[size];
            }
        };

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
}
