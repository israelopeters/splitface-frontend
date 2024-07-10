package com.northcoders.tatooine.service;

import com.northcoders.tatooine.model.Tattoo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

public interface TattooAPIService {
    @GET("/tattoo/tattoos") // add path
    Call<List<Tattoo>> getAllTattoos();

    @POST("/tattoo/artist")
    Call<Tattoo> addPost(@Body Tattoo post, @Query("id") long artistId);

    @PUT("/tattoo/{tattooId}")
    Call<Tattoo> updatePost(@Body Tattoo post, @Path("tattooId") long postId);

    @DELETE("/{id}")
    Call<Tattoo> deletePost(@Path("id") long postId);

//    @GET("tattoo/artist?id=") // add id aspect to path
//    Call<List<Tattoo>> getAllTattoosFromArtist();
}
