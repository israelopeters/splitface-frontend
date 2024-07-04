package com.northcoders.tatooine.ui.userprofileview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.tatooine.R;
import com.northcoders.tatooine.databinding.ArtistProfileImagesLayoutBinding;
import com.northcoders.tatooine.model.Tattoo;

import java.util.List;

public class TattooAdapter extends RecyclerView.Adapter<TattooAdapter.TattooViewHolder> {
    List<Tattoo> tattoos;
    Context context;

    public TattooAdapter(List<Tattoo> tattoos, Context context) {
        this.tattoos = tattoos;
        this.context = context;
    }

    @NonNull
    @Override
    public TattooViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArtistProfileImagesLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.artist_profile_images_layout, parent, false);
        return new TattooViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull TattooViewHolder holder, int position) {
        Tattoo tattoo = tattoos.get(position);
        holder.layoutBinding.setTattoo(tattoo);
        holder.layoutBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return tattoos.size();
    }

    public static class TattooViewHolder extends RecyclerView.ViewHolder{
        ArtistProfileImagesLayoutBinding  layoutBinding;

        public TattooViewHolder(ArtistProfileImagesLayoutBinding layoutBinding) {
            super(layoutBinding.getRoot());
            this.layoutBinding = layoutBinding;
        }
    }
}
