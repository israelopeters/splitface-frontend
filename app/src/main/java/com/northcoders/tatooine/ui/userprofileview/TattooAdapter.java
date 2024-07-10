package com.northcoders.tatooine.ui.userprofileview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.databinding.ArtistProfileImagesLayoutBinding;
import com.northcoders.tatooine.databinding.PostLayoutBinding;
import com.northcoders.tatooine.model.Tattoo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TattooAdapter extends RecyclerView.Adapter<TattooAdapter.TattooViewHolder> {
    private List<Tattoo> tattoos;
    private Context context;
    private com.northcoders.tatooine.ui.userprofileview.RecyclerViewInterface recyclerViewInterface;

    public TattooAdapter(List<Tattoo> tattoos, Context context, com.northcoders.tatooine.ui.userprofileview.RecyclerViewInterface recyclerViewInterface) {
        this.tattoos = tattoos;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public TattooViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ArtistProfileImagesLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.artist_profile_images_layout, parent, false);
        return new TattooViewHolder(binding, recyclerViewInterface);
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

        public TattooViewHolder(ArtistProfileImagesLayoutBinding binding, RecyclerViewInterface recyclerViewInterface) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }

        public void bind(Tattoo tattoo) {
            binding.setTattoo(tattoo);
            binding.executePendingBindings();
        }
    }
}
