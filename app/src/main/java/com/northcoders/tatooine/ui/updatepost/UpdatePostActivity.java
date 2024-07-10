package com.northcoders.tatooine.ui.updatepost;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.databinding.ActivityUpdatePostBinding;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.main.MainActivity;
import com.northcoders.tatooine.ui.main.MainViewModel;
import com.northcoders.tatooine.ui.main.PostAdapter;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewModel;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdatePostActivity extends AppCompatActivity {

    ActivityUpdatePostBinding binding;
    Tattoo post;
    UpdatePostClickHandlers handler;
    BottomNavigationView bottomNavigationView;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_post);

        post = getIntent().getParcelableExtra("post", Tattoo.class);
        String oldStylesString = getIntent().getParcelableExtra("styles", String.class);

        ArrayList<Tattoo.Style> stylesToUpload = new ArrayList<>();
        List<String> oldStylesList = new ArrayList<>(Arrays.asList(oldStylesString
                .split(", ")));

        for (int i = 0; i < oldStylesList.size(); i++) {
            String styleName = oldStylesList.get(i);
            stylesToUpload.add(new Tattoo.Style(getStyleId(styleName), styleName));
        }

        post.setStyles(stylesToUpload);

        AppCompatImageView uploadImagePreview = findViewById(R.id.uploadedImagePreview);
//        URL url = null;
//        try {
//            url = new URL(post.getDesign());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//
//        Glide.with(this)
//                .load(url)
//                .into(uploadImagePreview);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_post);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Set unbound views
        TextView selectStylesView = findViewById(R.id.selectStylesLayoutUpdatePost);

        handler = new UpdatePostClickHandlers(post, viewModel, this, selectStylesView);

        binding.setPost(post);
        binding.setClickHandler(handler);

        // Bottom navigation bar functionality
        bottomNavigationView = findViewById(R.id.bottomNavBarView);
        bottomNavigationView.setSelectedItemId(R.id.addPost);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                if (item.getItemId() == R.id.profile) {
                    startActivity(new Intent(getApplicationContext(), UserProfileViewActivity.class));
                    return true;
                }
                if (item.getItemId() == R.id.home) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    return true;
                }
                return item.getItemId() == R.id.addPost;
            }
        });

    }
    public long getStyleId(String style) {
        switch (style) {
            case "Traditional" : return 1L;
            case "Animals" : return 2L;
            case "Flowers" : return 3L;
            case "Birds" : return 4L;
            case "Nature scenes" : return 5L;
            case "Plants" : return 6L;
            case "Mythology" : return 7L;
            case "Symbols" : return 8L;
            case "Religion" : return 9L;
            case "Abstrakt" : return 10L;
            case "Pointillism" : return 11L;
            case "Tribal" : return 12L;
            case "Cybersigilism" : return 13L;
            default: return 1L;
        }
    }
}