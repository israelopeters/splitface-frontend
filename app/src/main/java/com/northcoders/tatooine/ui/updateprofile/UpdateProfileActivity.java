package com.northcoders.tatooine.ui.updateprofile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.lifecycle.ViewModelProvider;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.northcoders.tatooine.R;
import com.northcoders.tatooine.model.Artist;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;

public class UpdateProfileActivity extends AppCompatActivity {
    private UpdateProfileViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        viewModel = new ViewModelProvider(this).get(UpdateProfileViewModel.class);

        EditText name = findViewById(R.id.name);
        EditText location = findViewById(R.id.location);
        EditText email = findViewById(R.id.email);
        EditText passcode = findViewById(R.id.passcode);
        Button submitBtn = findViewById(R.id.saveButton);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artist artist = new Artist(name.getText().toString(), location.getText().toString(), email.getText().toString(), passcode.getText().toString());
                Long artistId = getIntent().getLongExtra("artistId", -1L);

                viewModel.editArtistProfile(artistId, artist).observe(UpdateProfileActivity.this, artistUpdated -> {
                    if (artistUpdated != null) {
                        Intent intent = new Intent(UpdateProfileActivity.this, UserProfileViewActivity.class);
                        intent.putExtra("artist", artistUpdated.getId());
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
    }
}
