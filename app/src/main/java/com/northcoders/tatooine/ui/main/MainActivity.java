package com.northcoders.tatooine.ui.main;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.ui.addpost.AddPostActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewLayout);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> testPriceList = new ArrayList<>();
        for (int i = 25; i < 100; i++) {
            testPriceList.add("Price" + i);
        }

        adapter = new PostAdapter(testPriceList);
        recyclerView.setAdapter(adapter);

        bottomNavigationView = findViewById(R.id.bottomNavBarView);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.addPost) {
                startActivity(new Intent(getApplicationContext(), AddPostActivity.class));
                return true;
            } else if (item.getItemId() == R.id.profile) {
                return true;
            } else if (item.getItemId() == R.id.home) {
                return true;
            }
            return false;
        });
    }

}