package com.northcoders.tatooine.ui.addpost;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationBarView;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.ui.main.MainActivity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class AddPostActivity extends AppCompatActivity {

    TextView textView;
    boolean[] selectedStyles;
    ArrayList<Integer> stylesList = new ArrayList<>();
    String[] stylesArray = {"REALISM", "WATERCOLOUR", "WILDCARD"};
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        // Select styles functionality
        textView = findViewById(R.id.selectStylesLayout);

        selectedStyles = new boolean[stylesArray.length];

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddPostActivity.this);
                builder.setTitle("Select styles");
                builder.setCancelable(false);

                builder.setMultiChoiceItems(stylesArray, selectedStyles, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            stylesList.add(which);
                            Collections.sort(stylesList);
                        } else {
                            stylesList.remove(Integer.valueOf(which));
                        }
                    }
                });
                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();

                        for (int i = 0; i < stylesList.size(); i++) {
                            stringBuilder.append(stylesArray[stylesList.get(i)]);
                            if (i != stylesList.size()-1) {
                                stringBuilder.append(", ");
                            }
                        }
                        textView.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < selectedStyles.length; i++) {
                            selectedStyles[i] = false;
                            stylesList.clear();
                            textView.setText("");
                        }
                    }
                });
                builder.show();
            }
        });

        // Bottom navigation bar functionality
        bottomNavigationView = findViewById(R.id.bottomNavBarView);
        bottomNavigationView.setSelectedItemId(R.id.addPost);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                if (item.getItemId() == R.id.addPost) {
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    return true;
                } else if (item.getItemId() == R.id.home) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    return true;
                }
                return false;
            }
        });

        // Upload image functionality
        AppCompatImageView uploadImagePreview = findViewById(R.id.uploadImagePreview);
        MaterialButton uploadButton = findViewById(R.id.uploadImageButton);

        ActivityResultLauncher<PickVisualMediaRequest> pickMedia = registerForActivityResult(
                new ActivityResultContracts.PickVisualMedia(), uri -> {
                    if (uri != null) {
                        Log.d("PhotoPicker", "Selected URI: " + uri);
                        uploadImagePreview.setImageURI(uri);
                    } else {
                        Log.d("PhotoPicker", "No media selected");
                    }
                }
        );

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickMedia.launch(new PickVisualMediaRequest.Builder()
                        .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                        .build());
            }
        });


    }

}
