package com.northcoders.tatooine.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static RetrofitInstance retrofitInstance = null;
    private static final String BASE_URL = "/"; // add base URL

    public static TattooAPIService getService(){

        if (retrofitInstance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

    }
}
