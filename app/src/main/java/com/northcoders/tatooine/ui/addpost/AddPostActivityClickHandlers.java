package com.northcoders.tatooine.ui.addpost;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.button.MaterialButton;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.main.MainViewModel;

import java.util.ArrayList;
import java.util.Collections;


public class AddPostActivityClickHandlers {

    Tattoo post;
    MainViewModel viewModel;
    Context context;
    Uri imageUri;

    TextView selectStylesView;
    MaterialButton submitButton;
    boolean[] selectedStyles;
    ArrayList<Integer> stylesList = new ArrayList<>();
    ArrayList<String> selectedStylesForPost = new ArrayList<>();
    String[] stylesArray = {"Traditional","Animals","Flowers","Birds","Nature scenes","Plants","Mythology","Symbols","Religion","Abstrakt","Pointillism","Tribal","Cybersigilism"};

    public AddPostActivityClickHandlers(Tattoo post,
                                        MainViewModel viewModel,
                                        Context context,
                                        TextView selectStylesView) {
        this.post = post;
        this.viewModel = viewModel;
        this.context = context;
        this.selectStylesView = selectStylesView;
        this.selectedStyles = new boolean[stylesArray.length];
    }

    // Select styles button
    public void onSelectStylesButtonClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
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
                    selectedStylesForPost.add((stylesArray[stylesList.get(i)]));
                    if (i != stylesList.size()-1) {
                        stringBuilder.append(", ");
                    }
                }
                selectStylesView.setText(stringBuilder.toString());
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
                    selectStylesView.setText("");
                }
            }
        });
        builder.show();
    }

}
