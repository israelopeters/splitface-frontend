package com.northcoders.tatooine.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.tatooine.service.RetrofitInstance;
import com.northcoders.tatooine.service.TattooAPIService;

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
                List<Tattoo> tattoos = response.body();
                liveTattooData.setValue(tattoos);
            }

            @Override
            public void onFailure(Call<List<Tattoo>> call, Throwable throwable) {

            }
        });
        return liveTattooData;
    }

    public MutableLiveData<List<Tattoo>> getMutableLiveDataForArtistSpecificTattoos(Long id) {
        TattooAPIService tattooAPIService = RetrofitInstance.getService();
        Call<List<Tattoo>> call = tattooAPIService.getAllTattoosFromArtist(id);
        call.enqueue(new Callback<List<Tattoo>>() {
            @Override
            public void onResponse(Call<List<Tattoo>> call, Response<List<Tattoo>> response) {
                List<Tattoo> tattoos = response.body();
                liveTattooData.setValue(tattoos);
            }

            @Override
            public void onFailure(Call<List<Tattoo>> call, Throwable throwable) {

            }
        });
        return liveTattooData;
    }
}
