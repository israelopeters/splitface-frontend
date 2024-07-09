package com.northcoders.tatooine.ui.userprofileview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.databinding.ActivityUserProfileViewBinding;
import com.northcoders.tatooine.model.Artist;
import com.northcoders.tatooine.model.Style;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.addpost.AddPostActivity;
import com.northcoders.tatooine.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class UserProfileViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Tattoo> tattoos;
    private TattooAdapter adapter;
    private UserProfileViewModel viewModel;
    private ActivityUserProfileViewBinding binding;
    private Artist artist;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile_view);
        viewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);

        Long artistId = getIntent().getLongExtra("artist", -1L);

        recyclerView = binding.recyclerViewOfPosts;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        tattoos = new ArrayList<>();
        adapter = new TattooAdapter(tattoos, this);
        recyclerView.setAdapter(adapter);

        getArtistDetails(artistId);

        // Bottom Navigation Bar functionality
        bottomNavigationView = findViewById(R.id.bottomNavBarView);
        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.addPost) {
                startActivity(new Intent(getApplicationContext(), AddPostActivity.class));
                return true;
            }
            if (item.getItemId() == R.id.profile) {
                return true;
            }
            if (item.getItemId() == R.id.home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                return true;
            }
            return false;
        });
    }

    private void getArtistDetails(Long artistId) {
        viewModel.getArtistDetails(artistId).observe(this, new Observer<Artist>() {
            @Override
            public void onChanged(Artist artistFromLiveData) {
                if (artistFromLiveData != null) {
                    artist = artistFromLiveData;
                    binding.setArtist(artist);
                    adapter.notifyDataSetChanged();
                    getAllTattoos(artist.getId());
                }
            }
        });
    }

    private void getAllTattoos(Long id) {
        viewModel.getAllTattoosFromSpecificArtist(id).observe(this, new Observer<List<Tattoo>>() {
            @Override
            public void onChanged(List<Tattoo> tattoosFromLiveData) {
                tattoos.clear();
                if (tattoosFromLiveData != null) {
                    tattoos.addAll(tattoosFromLiveData);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
