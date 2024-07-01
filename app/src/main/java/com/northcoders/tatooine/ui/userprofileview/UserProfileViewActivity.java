package com.northcoders.tatooine.ui.userprofileview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.northcoders.tatooine.R;

import java.util.ArrayList;

public class UserProfileViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewOfPosts);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> testPriceList = new ArrayList<>();
        for (int i = 25; i < 100; i++) {
            testPriceList.add("Price" + i);
        }

        adapter = new PostAdapter(testPriceList);
        recyclerView.setAdapter(adapter);
    }
}