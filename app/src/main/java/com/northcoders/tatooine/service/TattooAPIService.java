package com.northcoders.tatooine.service;

import com.northcoders.tatooine.model.Tattoo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TattooAPIService {
    @GET("/tattoo/tattoos") // add path
    Call<List<Tattoo>> getAllTattoos();

//    @GET("tattoo/artist?id=") // add id aspect to path
//    Call<List<Tattoo>> getAllTattoosFromArtist();
}
