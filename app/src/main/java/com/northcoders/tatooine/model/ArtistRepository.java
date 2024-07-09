package com.northcoders.tatooine.model;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.tatooine.service.ArtistAPIService;
import com.northcoders.tatooine.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistRepository {
    private ArtistAPIService apiService;
    private Application application;

    public ArtistRepository(Application application) {
        this.application = application;
    }

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

    public MutableLiveData<String> signUp(Artist artist){
        MutableLiveData<String> liveData = new MutableLiveData<>();

        apiService.signUp(artist).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                liveData.setValue(null);
            }
        });
        return liveData;
    }

    public interface LoginCallback {
        void onSuccess(Artist artist);
        void onError(String error);
    }


    public LiveData<Artist> getArtistDetails(Long artistId) {
        MutableLiveData<Artist> artistLiveData = new MutableLiveData<>();

        apiService.getArtistById(artistId).enqueue(new Callback<Artist>() {
            @Override
            public void onResponse(Call<Artist> call, Response<Artist> response) {
                if (response.isSuccessful()) {
                    artistLiveData.setValue(response.body());
                } else {
                    artistLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Artist> call, Throwable t) {
                artistLiveData.setValue(null);
            }
        });

        return artistLiveData;
    }

    public MutableLiveData<String> deleteArtistById(Long artistId) {
        MutableLiveData<String> result = new MutableLiveData<>();
        apiService.deleteArtistById(artistId).enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    result.setValue(response.body());
                } else {
                    result.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {

            }
        });
        return result;
    }

    public MutableLiveData<Artist> editArtistById(Long artistId, Artist artist) {
        MutableLiveData<Artist> artistLiveData = new MutableLiveData<>();
        apiService.editProfile(artistId, artist).enqueue(new Callback<Artist>() {
            @Override
            public void onResponse(Call<Artist> call, Response<Artist> response) {
                if (response.isSuccessful()) {
                    artistLiveData.setValue(response.body());
                } else {
                    artistLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Artist> call, Throwable t) {
                artistLiveData.setValue(null);
            }
        });
        return artistLiveData;
    }

}
