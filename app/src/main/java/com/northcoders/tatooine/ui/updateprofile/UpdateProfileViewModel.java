package com.northcoders.tatooine.ui.updateprofile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.tatooine.model.Artist;
import com.northcoders.tatooine.model.ArtistRepository;

public class UpdateProfileViewModel extends AndroidViewModel {
    private ArtistRepository artistRepository;

    public UpdateProfileViewModel(@NonNull Application application) {
        super(application);
        artistRepository = new ArtistRepository(application);
    }

    public LiveData<Artist> editArtistProfile(Long id, Artist artist){
        return artistRepository.editArtistById(id, artist);
    }
}
