package com.northcoders.tatooine.model;

import android.app.Application;

import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;
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

    public void addPost(Tattoo post, long artistId) {
        Call<Tattoo> call = RetrofitInstance.getService().addPost(post, artistId);

        call.enqueue(new Callback<Tattoo>() {
            int duration = Toast.LENGTH_SHORT;

            @Override
            public void onResponse(Call<Tattoo> call, Response<Tattoo> response) {
                CharSequence feedback = "Post added!";
                Toast.makeText(application.getApplicationContext(), feedback, duration).show();
            }

            @Override
            public void onFailure(Call<Tattoo> call, Throwable t) {
                CharSequence feedback = "Post could not be added!";
                Toast.makeText(application.getApplicationContext(), feedback, duration).show();
                call.cancel();
            }
        });
    }

    public void updatePost(Tattoo post, long postId) {
        Call<Tattoo> call = RetrofitInstance.getService().updatePost(post, postId);

        call.enqueue(new Callback<Tattoo>() {
            int duration = Toast.LENGTH_SHORT;

            @Override
            public void onResponse(Call<Tattoo> call, Response<Tattoo> response) {
                CharSequence feedback = "Post updated!";
                Toast.makeText(application.getApplicationContext(), feedback, duration).show();
            }

            @Override
            public void onFailure(Call<Tattoo> call, Throwable t) {
                CharSequence feedback = "Post could not be updated!";
                Toast.makeText(application.getApplicationContext(), feedback, duration).show();
                call.cancel();
            }
        });
    }

    public void deletePost(long postId) {
        Call<Tattoo> call = RetrofitInstance.getService().deletePost(postId);

        call.enqueue(new Callback<Tattoo>() {
            int duration = Toast.LENGTH_SHORT;

            @Override
            public void onResponse(Call<Tattoo> call, Response<Tattoo> response) {
                CharSequence feedback = "Post deleted!";
                Toast.makeText(application.getApplicationContext(), feedback, duration).show();
            }

            @Override
            public void onFailure(Call<Tattoo> call, Throwable t) {
                CharSequence feedback = "Post could not be deleted!";
                Toast.makeText(application.getApplicationContext(), feedback, duration).show();
                call.cancel();
            }
        });
    }
}
