package com.northcoders.tatooine.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://Tatooine-env.eba-pxrgyckg.eu-west-2.elasticbeanstalk.com/";// add base URL

    public static TattooAPIService getService(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TattooAPIService.class);
    }

    public static ArtistAPIService getArtistService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ArtistAPIService.class);
    }
}
