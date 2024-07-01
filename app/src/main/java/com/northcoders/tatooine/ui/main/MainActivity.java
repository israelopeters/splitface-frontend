package com.northcoders.tatooine.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import static android.widget.GridLayout.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewLayout);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
//        layoutManager = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> testPriceList = new ArrayList<>();
        for (int i = 25; i < 100; i++) {
            testPriceList.add("Price" + i);
        }

        adapter = new PostAdapter(testPriceList);
        recyclerView.setAdapter(adapter);

    }
}