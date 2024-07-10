package com.northcoders.tatooine.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.model.Artist;
import com.northcoders.tatooine.ui.login.LoginActivity;
import com.northcoders.tatooine.ui.updateprofile.UpdateProfileActivity;
import com.northcoders.tatooine.ui.updateprofile.UpdateProfileViewModel;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;

public class SignUpActivity extends AppCompatActivity {
    private SignUpViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        EditText name = findViewById(R.id.name);
        EditText location = findViewById(R.id.location);
        EditText email = findViewById(R.id.email);
        EditText passcode = findViewById(R.id.passcode);
        Button submitBtn = findViewById(R.id.signInButton);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artist artist = new Artist(name.getText().toString(), location.getText().toString(), email.getText().toString(), passcode.getText().toString());

                viewModel.signUp(artist).observe(SignUpActivity.this, artistUpdated -> {
//                    if (artistUpdated != null) {
                        Intent intent = new Intent(SignUpActivity.this, UserProfileViewActivity.class);
                        startActivity(intent);
                        finish();
//                    }
                });
            }
        });

        FloatingActionButton bckBtn = (FloatingActionButton) findViewById(R.id.backBtn);
        bckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}