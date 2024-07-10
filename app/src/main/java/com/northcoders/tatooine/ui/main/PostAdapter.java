package com.northcoders.tatooine.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.databinding.ActivityMainBinding;
import com.northcoders.tatooine.databinding.ArtistProfileImagesLayoutBinding;
import com.northcoders.tatooine.databinding.PostLayoutBinding;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.userprofileview.TattooAdapter;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Tattoo> tattoos;
    private Context context;
    RecyclerViewInterface recyclerViewInterface;

    public PostAdapter(List<Tattoo> tattoos, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.tattoos = tattoos;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @NotNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PostLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.post_layout, parent, false);
        return new PostViewHolder(binding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PostViewHolder holder, int position) {
        Tattoo tattoo = tattoos.get(position);
        holder.binding.setTattoo(tattoo);
        URL url = null;
        try {
            url = new URL(tattoos.get(position).getDesign());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Glide.with(context)
                .load(url)
                .into(holder.binding.postImageView);
    }

    @Override
    public int getItemCount() {
        return tattoos.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        private PostLayoutBinding binding;

        public PostViewHolder(PostLayoutBinding binding, RecyclerViewInterface recyclerViewInterface) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClicked(position);
                        }
                    }
                }
            });
        }
    }
    public void setFilteredList(ArrayList<Tattoo> filteredList) {
        tattoos = filteredList;
    }
}

