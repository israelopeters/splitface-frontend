package com.northcoders.tatooine.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.northcoders.tatooine.R;
import com.northcoders.tatooine.model.Artist;
import com.northcoders.tatooine.model.ArtistRepository;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;

public class LoginActivity extends AppCompatActivity {

    private ArtistRepository artistRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        artistRepository = new ArtistRepository();

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.passcode);
        Button signInButton = findViewById(R.id.signInButton);

        signInButton.setOnClickListener(view -> {
            String usernameInput = username.getText().toString();
            String passwordInput = password.getText().toString();

            artistRepository.login(usernameInput, passwordInput, new ArtistRepository.LoginCallback() {
                @Override
                public void onSuccess(Artist artist) {
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, UserProfileViewActivity.class);
                    intent.putExtra("artist", artist.getId());
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onError(String error) {
                    Toast.makeText(LoginActivity.this, "LOGIN UNSUCCESSFUL: " + error, Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}