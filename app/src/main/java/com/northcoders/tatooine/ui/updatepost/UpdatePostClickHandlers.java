package com.northcoders.tatooine.ui.updatepost;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.main.MainViewModel;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewActivity;
import com.northcoders.tatooine.ui.userprofileview.UserProfileViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdatePostClickHandlers {

    Tattoo post;
    MainViewModel viewModel;
    long id;
    Context context;

    public UpdatePostClickHandlers(Tattoo post, MainViewModel viewModel, Context context) {
        this.post = post;
        this.viewModel = viewModel;
        this.id = post.getId();
        this.context = context;
    }

    public void onSubmitButtonClicked(View view) {
//        List<String> styles = new ArrayList<>(Arrays.asList(post
//                .getStyles()
//                .split(", ")));
        Tattoo updatedPost = new Tattoo(
                post.getId(),
                post.getDesign(),
                post.getPrice(),
                post.getHoursWorked(),
                null, //Refactor with data
                post.getTimePosted()
        );

        viewModel.updatePost(id, updatedPost);
        Toast.makeText(context, "Post updated!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, UserProfileViewActivity.class);
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

}
