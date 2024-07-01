package com.northcoders.tatooine.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.northcoders.tatooine.R;
import com.northcoders.tatooine.ui.login.LoginActivity;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this, UserProfileViewActivity.class));
    }
}