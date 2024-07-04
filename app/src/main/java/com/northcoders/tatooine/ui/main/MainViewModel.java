package com.northcoders.tatooine.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.model.TattooRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    TattooRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.repository = new TattooRepository(application);
    }

    public LiveData<List<Tattoo>> getAllTattoos(){
        return repository.getMutableLiveData();
    }
}
