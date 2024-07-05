package com.northcoders.tatooine.ui.userprofileview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.tatooine.model.Artist;
import com.northcoders.tatooine.model.ArtistRepository;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.model.TattooRepository;

import java.util.List;

public class UserProfileViewModel extends AndroidViewModel {
    private TattooRepository tattooRepository;
    private ArtistRepository artistRepository;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        this.tattooRepository = new TattooRepository(application);
        this.artistRepository = new ArtistRepository();
    }

    public LiveData<Artist> getArtistDetails(Long artistId) {
        return artistRepository.getArtistDetails(artistId);
    }

    public LiveData<List<Tattoo>> getAllTattoosFromSpecificArtist(Long id) {
        return tattooRepository.getMutableLiveDataForArtistSpecificTattoos(id);
    }
}
