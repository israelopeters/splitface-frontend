package com.northcoders.tatooine.ui.userprofileview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.databinding.ArtistProfileImagesLayoutBinding;
import com.northcoders.tatooine.model.Tattoo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TattooAdapter extends RecyclerView.Adapter<TattooAdapter.TattooViewHolder> {
    private List<Tattoo> tattoos;
    private Context context;

    public TattooAdapter(List<Tattoo> tattoos, Context context) {
        this.tattoos = tattoos;
        this.context = context;
    }

    @NonNull
    @Override
    public TattooViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ArtistProfileImagesLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.artist_profile_images_layout, parent, false);
        return new TattooViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TattooViewHolder holder, int position) {
        Tattoo tattoo = tattoos.get(position);
        holder.bind(tattoo);
        URL url = null;
        try {
            url = new URL(tattoos.get(position).getDesign());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Glide.with(context)
                .load(url)
                .into(holder.binding.artImage);
    }

    @Override
    public int getItemCount() {
        return tattoos.size();
    }

    public static class TattooViewHolder extends RecyclerView.ViewHolder {
        private ArtistProfileImagesLayoutBinding binding;

        public TattooViewHolder(ArtistProfileImagesLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Tattoo tattoo) {
            binding.setTattoo(tattoo);
            binding.executePendingBindings();
        }
    }
}
