package com.northcoders.tatooine.model;

import com.northcoders.tatooine.service.ArtistAPIService;
import com.northcoders.tatooine.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistRepository {
    private ArtistAPIService apiService;

    public ArtistRepository() {
        apiService = RetrofitInstance.getArtistService();
    }

    public void login(String username, String password, final LoginCallback callback) {
        Call<Artist> call = apiService.login(username, password);
        call.enqueue(new Callback<Artist>() {
            @Override
            public void onResponse(Call<Artist> call, Response<Artist> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Login failed");
                }
            }

            @Override
            public void onFailure(Call<Artist> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public interface LoginCallback {
        void onSuccess(Artist artist);
        void onError(String error);
    }
}
