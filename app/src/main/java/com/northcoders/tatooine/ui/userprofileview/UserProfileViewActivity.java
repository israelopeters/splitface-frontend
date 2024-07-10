package com.northcoders.tatooine.ui.userprofileview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
import com.northcoders.tatooine.model.Tattoo.Style;

import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.addpost.AddPostActivity;
//import com.northcoders.tatooine.ui.googlemaps.MapsActivity;
import com.northcoders.tatooine.ui.login.LoginActivity;
import com.northcoders.tatooine.ui.main.MainActivity;
import com.northcoders.tatooine.ui.updatepost.UpdatePostActivity;
import com.northcoders.tatooine.ui.updateprofile.UpdateProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class UserProfileViewActivity extends AppCompatActivity implements RecyclerViewInterface{
    private RecyclerView recyclerView;
    private RecyclerViewInterface recyclerViewInterface;
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

        tattoos = new ArrayList<>();
        Long artistId = getIntent().getLongExtra("artist", -1L);
        getArtistDetails(artistId);

        recyclerView = binding.recyclerViewOfPosts;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new TattooAdapter(tattoos, this, this);
        recyclerView.setAdapter(adapter);

        //        recyclerView = binding.recyclerViewMain;
        //        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //
        //        adapter = new PostAdapter(tattoos, this, this);
        //        recyclerView.setAdapter(adapter);
        //
        //        recyclerView.setHasFixedSize(true);
        //
        //        adapter.notifyDataSetChanged();


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

        Button deleteProfile = findViewById(R.id.deleteProfileButton);
        deleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.deleteArtistProfile(getIntent().getLongExtra("artist", -1L));
                Toast.makeText(UserProfileViewActivity.this, "PROFILE DELETED", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserProfileViewActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button editProfile = findViewById(R.id.editProfileButton);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileViewActivity.this, UpdateProfileActivity.class);
                startActivity(intent);
            }
        });

//        Button mapView = findViewById(R.id.locationButton);
//        mapView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(UserProfileViewActivity.this, MapsActivity.class);
//                startActivity(intent);
//            }
//        });

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
                    Log.i("tattoos", tattoosFromLiveData.toString());
                    tattoos.addAll(tattoosFromLiveData);
                    Log.i("tattoos", tattoos.toString());
                }

                adapter.notifyDataSetChanged();
            }
        });
    }


    private void displayInRecyclerView(){

        List<Tattoo> testTatts = new ArrayList<>();

        recyclerView = binding.recyclerViewOfPosts;
        adapter = new TattooAdapter(testTatts, this, recyclerViewInterface);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(int position) {
        Intent intent  = new Intent(this, UpdatePostActivity.class);
        Tattoo post = tattoos.get(position);
        Log.i("TATTOO ::: ", "TEST: " + post.getPrice());
        Log.i("TATTOO ::: ", "TEST: " + post.getHoursWorked());
        Log.i("TATTOO ::: ", "TEST: " + post.getTimePosted());
        Log.i("TATTOO ::: ", "TEST: " + post.getDesign());
        Log.i("TATTOO ::: ", "TEST: " + post.getStyles().toString());
        intent.putExtra("post", tattoos.get(position));
        intent.putExtra("styles", tattoos.get(position).getStyles());
        startActivity(intent);
    }
}
