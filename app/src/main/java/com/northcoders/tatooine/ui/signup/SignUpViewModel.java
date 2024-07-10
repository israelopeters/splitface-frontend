package com.northcoders.tatooine.ui.signup;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.tatooine.model.Artist;
import com.northcoders.tatooine.model.ArtistRepository;

public class SignUpViewModel extends AndroidViewModel {
    private ArtistRepository artistRepository;

    public SignUpViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> signUp(Artist artist){
        return artistRepository.signUp(artist);
    }
}
