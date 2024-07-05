package com.northcoders.tatooine.ui.main;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.northcoders.tatooine.R;

import com.northcoders.tatooine.databinding.ActivityMainBinding;
import com.northcoders.tatooine.databinding.ActivityUserProfileViewBinding;
import com.northcoders.tatooine.model.Style;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.login.LoginActivity;
import com.northcoders.tatooine.ui.userprofileview.TattooAdapter;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;

import com.northcoders.tatooine.ui.googlemaps.MapsActivity;
import com.northcoders.tatooine.ui.addpost.AddPostActivity;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewModel;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Tattoo> tattoos;
    private PostAdapter adapter;
    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        recyclerView = binding.recyclerViewMain;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        tattoos = new ArrayList<>();
        adapter = new PostAdapter(tattoos, this);
        recyclerView.setAdapter(adapter);

        getAllTattoos();
    }


        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.addPost) {
                startActivity(new Intent(getApplicationContext(), AddPostActivity.class));
                return true;
            }
            if (item.getItemId() == R.id.profile) {
                startActivity(new Intent(getApplicationContext(), UserProfileViewActivity.class));
                return true;
            }
            if (item.getItemId() == R.id.home) {
                return true;

    private void getAllTattoos() {
        viewModel.getAllTattoos().observe(this, new Observer<List<Tattoo>>() {
            @Override
            public void onChanged(List<Tattoo> tattoosFromLiveData) {
                tattoos.clear();
                if (tattoosFromLiveData != null) {
                    tattoos.addAll(tattoosFromLiveData);
                }
                List<Style> styles = List.of(new Style(1L, "REALISM"), new Style(2L, "FINE LINE"), new Style(3L, "WATERCOLOUR"));
                tattoos.add(new Tattoo(1L, "£1000", "", "3 hours", styles, "Now"));
                tattoos.add(new Tattoo(1L, "£100", "", "3 hours", styles, "Now"));
                adapter.notifyDataSetChanged();

            }
        });
    }
}