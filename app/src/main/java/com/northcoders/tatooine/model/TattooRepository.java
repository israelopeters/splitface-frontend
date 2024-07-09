package com.northcoders.tatooine.model;

import android.app.Application;

import android.util.JsonReader;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.tatooine.service.RetrofitInstance;
import com.northcoders.tatooine.service.TattooAPIService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TattooRepository {
    private MutableLiveData<List<Tattoo>> liveTattooData = new MutableLiveData<>();
    Application application;

    public TattooRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Tattoo>> getMutableLiveData() {
        TattooAPIService tattooAPIService = RetrofitInstance.getService();
        Call<List<Tattoo>> call = tattooAPIService.getAllTattoos();

        call.enqueue(new Callback<List<Tattoo>>() {
            @Override
            public void onResponse(Call<List<Tattoo>> call, Response<List<Tattoo>> response) {
                if (response.isSuccessful()) {
                    List<Tattoo> tattoos = response.body();
                    Log.i("Tattoos List", "On response: " + tattoos);
                    liveTattooData.setValue(tattoos);
                } else {
                    System.out.println("Tattoos List Request Error :: " + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Tattoo>> call, Throwable throwable) {
                Log.i("Tattoos List", "Failed response: " + throwable.getMessage());
            }
        });
        return liveTattooData;
    }
}
