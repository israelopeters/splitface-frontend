package com.northcoders.tatooine.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tattoo> getTattoos() {
        return tattoos;
    }

    public void setTattoos(List<Tattoo> tattoos) {
        this.tattoos = tattoos;
    }
}
