package com.northcoders.tatooine.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import androidx.lifecycle.MutableLiveData;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.model.TattooRepository;
import retrofit2.http.Body;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    TattooRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.repository = new TattooRepository(application);
    }

    public MutableLiveData<List<Tattoo>> getAllTattoos(){
        return repository.getMutableLiveData();
    }

    public void addPost(@Body Tattoo post) {};

    public void updatePost(long id, @Body Tattoo post) {};

    public void deletePost(long id) {};
}
