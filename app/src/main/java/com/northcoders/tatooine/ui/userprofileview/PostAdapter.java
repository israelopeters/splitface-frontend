package com.northcoders.tatooine.ui.userprofileview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.northcoders.tatooine.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private ArrayList<String> priceList;

    public PostAdapter(ArrayList<String> priceList) {
        this.priceList = priceList;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView priceHolder;
        TextView timeTakenHolder;
        View layout;

        public PostViewHolder(@NonNull @NotNull View postView) {
            super(postView);
            layout = postView;
            priceHolder = (TextView) postView.findViewById(R.id.artPrice);
            timeTakenHolder = (TextView) postView.findViewById(R.id.timeSpentOnArt);
        }
    }

    public void add(int position, String item) {
        priceList.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        priceList.remove(position);
        notifyItemRemoved(position);
    }


    @NonNull
    @NotNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.artist_profile_images_layout, parent, false);
        PostViewHolder postViewHolder = new PostViewHolder(view);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PostViewHolder postViewHolder, @SuppressLint("RecyclerView") int position) {
        final String price = priceList.get(position);
        postViewHolder.priceHolder.setText(price);
        postViewHolder.priceHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return priceList.size();
    }
}