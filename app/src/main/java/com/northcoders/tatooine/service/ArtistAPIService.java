package com.northcoders.tatooine.service;

import com.northcoders.tatooine.model.Tattoo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArtistAPIService {
    @GET("artist")
    Call<Tattoo> checkPasswordAndEmailMatch(
            @Query("email") String email,
            @Query("password") String password);
}
