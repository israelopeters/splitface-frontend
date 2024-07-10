package com.northcoders.tatooine.ui.userprofileview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.model.TattooRepository;
import retrofit2.http.Body;

import java.util.List;

public class UserProfileViewModel extends AndroidViewModel {
    TattooRepository repository;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        this.repository = new TattooRepository(application);
    }

    public LiveData<List<Tattoo>> getAllTattoos(){
        return repository.getMutableLiveData();
    }

    public LiveData<List<Tattoo>> getAllTattoosFromSpecificArtist(Long id){
        return repository.getMutableLiveDataForArtistSpecificTattoos(id);
    }
}
