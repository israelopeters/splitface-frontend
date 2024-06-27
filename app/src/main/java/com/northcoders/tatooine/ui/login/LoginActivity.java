package com.northcoders.tatooine.ui.login;

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

public class LoginActivity extends AppCompatActivity {

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

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.passcode);

        Button signInButton = findViewById(R.id.signInButton);

        signInButton.setOnClickListener(view -> {
            String usernameInput = username.getText().toString();
            String passwordInput = password.getText().toString();

            if ("admin".equals(usernameInput) && "adminpass".equals(passwordInput)) {
                // Correct password
                Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
            } else {
                // Failed login
                Toast.makeText(LoginActivity.this, "LOGIN UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
            }
        });

    }
}