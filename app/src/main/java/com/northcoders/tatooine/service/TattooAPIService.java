package com.northcoders.tatooine.service;

import com.northcoders.tatooine.model.Tattoo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TattooAPIService {
    @GET("tattoo") // add path
    Call<List<Tattoo>> getAllTattoos(); // change/ add path?
}
