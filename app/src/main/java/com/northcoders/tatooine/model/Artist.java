package com.northcoders.tatooine.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist extends BaseObservable {
    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private String location;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("tattoos")
    private List<Tattoo> tattoos;

    public Artist() {
    }

    public Artist(Long id, String email, String name, String location, String password, List<Tattoo> tattoos) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.location = location;
        this.password = password;
        this.tattoos = tattoos;
    }

    public Artist(String name, String location, String email, String password) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.password = password;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bindable
    public List<Tattoo> getTattoos() {
        return tattoos;
    }

    public void setTattoos(List<Tattoo> tattoos) {
        this.tattoos = tattoos;
    }
}
