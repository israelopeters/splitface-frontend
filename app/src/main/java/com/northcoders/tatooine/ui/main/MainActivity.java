package com.northcoders.tatooine.ui.main;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.northcoders.tatooine.R;

import com.northcoders.tatooine.databinding.ActivityMainBinding;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;

import com.northcoders.tatooine.ui.addpost.AddPostActivity;
import org.jetbrains.annotations.NotNull;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Tattoo> tattoos;
    private PostAdapter adapter;
    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        getAllTattoos();

        // Bottom navigation bar functionality
        bottomNavigationView = findViewById(R.id.bottomNavBarView);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                if (item.getItemId() == R.id.profile) {
                    startActivity(new Intent(getApplicationContext(), UserProfileViewActivity.class));
                    return true;
                }
                if (item.getItemId() == R.id.addPost) {
                    startActivity(new Intent(getApplicationContext(), AddPostActivity.class));
                    return true;
                }
                return item.getItemId() == R.id.home;
            }
        });
    }

    private void getAllTattoos() {
        viewModel.getAllTattoos().observe(this, new Observer<List<Tattoo>>() {
            @Override
            public void onChanged(List<Tattoo> tattoosFromLiveData) {
                tattoos = (ArrayList<Tattoo>) tattoosFromLiveData;
                displayInRecyclerView();
            }
        });
    }

    public void displayInRecyclerView() {
        recyclerView = binding.recyclerViewMain;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new PostAdapter(tattoos, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);

        adapter.notifyDataSetChanged();
    }
}