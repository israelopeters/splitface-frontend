package com.northcoders.tatooine.ui.main;

import android.util.Log;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;
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
import com.northcoders.tatooine.ui.updatepost.UpdatePostActivity;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;

import com.northcoders.tatooine.ui.addpost.AddPostActivity;
import org.jetbrains.annotations.NotNull;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    private ArrayList<Tattoo> tattoos;
    private PostAdapter adapter;
    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    private SearchView searchView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        getAllTattoos();

        searchView = findViewById(R.id.searchViewPostsStyle);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchText) {
                filteredSearchPostsStyle(searchText);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

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

    private void filteredSearchPostsStyle(String searchArtist) {

        ArrayList<Tattoo> filteredListAlbumArtist = new ArrayList<>();

        for (Tattoo post : tattoos) {
            if (post.getStyles().toLowerCase().contains(searchArtist.toLowerCase())) {
                filteredListAlbumArtist.add(post);
            }
        }
        if (filteredListAlbumArtist.isEmpty()) {
            Toast.makeText(this, "No styles found!", Toast.LENGTH_SHORT).show();
        }
        adapter.setFilteredList(filteredListAlbumArtist);
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

        adapter = new PostAdapter(tattoos, this, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(int position) {
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