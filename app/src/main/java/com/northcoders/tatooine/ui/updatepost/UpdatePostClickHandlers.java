package com.northcoders.tatooine.ui.updatepost;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.button.MaterialButton;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.main.MainActivity;
import com.northcoders.tatooine.ui.main.MainViewModel;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class UpdatePostClickHandlers {

    Tattoo post;
    MainViewModel viewModel;
    long id;
    Context context;
    TextView getSelectStylesView;

    TextView selectStylesView;
    MaterialButton submitButton;
    boolean[] selectedStyles;
    ArrayList<Integer> stylesList = new ArrayList<>();
    ArrayList<String> selectedStylesForPost = new ArrayList<>();
    final String[] stylesInDb = {"Traditional","Animals","Flowers","Birds","Nature scenes","Plants","Mythology","Symbols","Religion","Abstrakt","Pointillism","Tribal","Cybersigilism"};
    String[] stylesArray;

    public UpdatePostClickHandlers(Tattoo post, MainViewModel viewModel, Context context, TextView selectStylesView) {
        this.post = post;
        this.viewModel = viewModel;
        this.id = post.getId();
        this.context = context;
        this.stylesArray = mergeArrays(
                stylesInDb,
                post.getStyles().split(", ")
        );
        this.selectStylesView = selectStylesView;
    }

    public void onSubmitButtonClicked(View view) {
        ArrayList<Tattoo.Style> stylesToUpload = new ArrayList<>();
        for (int i = 0; i < selectedStylesForPost.size(); i++) {
            stylesToUpload.add(new Tattoo.Style((long) i, selectedStylesForPost.get(i)));
        }

        Tattoo updatedPost = new Tattoo(
                post.getId(),
                post.getDesign(),
                post.getPrice(),
                post.getHoursWorked(),
                stylesToUpload, //Refactor with data
                post.getTimePosted()
        );

        viewModel.updatePost(updatedPost, id);
        Toast.makeText(context, "Post updated!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void onFabBackButtonClicked(View view) {
        Intent intent = new Intent(context, UserProfileViewActivity.class);
        context.startActivity(intent);
    }

    public void onDeleteButtonClicked(View view) {
        //viewModel.deletePost(post.getId());
        Toast.makeText(context, "Post deleted!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, UserProfileViewActivity.class);
        context.startActivity(intent);
    }

    // Select styles button
    public void onSelectStylesButtonClicked(View v) {
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

    public String[] mergeArrays (String[] arrayOne, String[] arrayTwo) {
        String[] arrayMerged = new String[arrayOne.length + arrayTwo.length];

        int count = 0;
        for(int i = 0; i < arrayOne.length; i++) {
            if (!Arrays.asList(stylesInDb).contains(arrayOne[i])) {
                arrayMerged[i] = arrayOne[i];
                count++;
            }
        }
        for(int j = 0; j < arrayTwo.length;j++) {
            if (!Arrays.asList(stylesInDb).contains(arrayTwo[j])) {
                arrayMerged[count++] = arrayTwo[j];
                count++;
            }
        }
        return arrayMerged;
    }

}
