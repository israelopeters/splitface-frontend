package com.northcoders.tatooine.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.databinding.ActivityMainBinding;
import com.northcoders.tatooine.databinding.ArtistProfileImagesLayoutBinding;
import com.northcoders.tatooine.databinding.PostLayoutBinding;
import com.northcoders.tatooine.model.Tattoo;
import com.northcoders.tatooine.ui.userprofileview.TattooAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Tattoo> tattoos;
    private Context context;

    public PostAdapter(List<Tattoo> tattoos, Context context) {
        this.tattoos = tattoos;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PostLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.post_layout, parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PostViewHolder holder, int position) {
        Tattoo tattoo = tattoos.get(position);
        holder.binding.setTattoo(tattoo);
    }

    @Override
    public int getItemCount() {
        return tattoos.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        private PostLayoutBinding binding;

        public PostViewHolder(PostLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public void setFilteredList(ArrayList<Tattoo> filteredList) {
        tattoos = filteredList;
    }
}

