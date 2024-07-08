package com.northcoders.tatooine.ui.updatepost;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.databinding.ActivityUpdatePostBinding;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.main.MainViewModel;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewModel;

public class UpdatePostActivity extends AppCompatActivity {

    ActivityUpdatePostBinding binding;
    Tattoo post;
    UpdatePostClickHandlers handler;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_post);

        post = getIntent().getParcelableExtra("post", Tattoo.class);

        //AppCompatImageView uploadImagePreview = findViewById(R.id.uploadedImagePreview);
        //uploadImagePreview.setImageURI(post.getDesign());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_post);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        handler = new UpdatePostClickHandlers(post, viewModel, this);

        binding.setPost(post);
        binding.setClickHandler(handler);

    }
}