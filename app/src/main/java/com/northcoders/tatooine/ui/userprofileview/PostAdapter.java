package com.northcoders.tatooine.ui.userprofileview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.northcoders.tatooine.R;
import com.northcoders.tatooine.model.Tattoo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<> {

//    List<Tattoo> tattoos;
//    Context context;
//    RecyclerViewInterface recyclerViewInterface;
//
//    public PostAdapter(List<Tattoo> tattoos, Context context, RecyclerViewInterface recyclerViewInterface) {
//        this.tattoos = tattoos;
//        this.context = context;
//        this.recyclerViewInterface = recyclerViewInterface;
//    }
//
//    @NonNull
//    @Override
//    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        AlbumPresentationBinding albumPresentationBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.album_presentation, parent, false);
//
//        return new AlbumViewHolder(albumPresentationBinding, recyclerViewInterface);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
//        Tattoo tattoo = tattoos.get(position);
//
//        holder.albumItemBinding.setAlbum(album);
//    }
//
//    @Override
//    public int getItemCount() {
//        return albumList.size();
//    }
//
//    public void setFilteredList(ArrayList<Album> filteredAlbums) {
//        this.albumList = filteredAlbums;
//        notifyDataSetChanged();
//    }
//
//    public static class AlbumViewHolder extends RecyclerView.ViewHolder{
//        private AlbumPresentationBinding albumItemBinding;
//
//        public AlbumViewHolder (AlbumPresentationBinding albumItemBinding, RecyclerViewInterface recyclerViewInterface) {
//            super(albumItemBinding.getRoot());
//            this.albumItemBinding = albumItemBinding;
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (recyclerViewInterface != null){
//                        int position = getAdapterPosition();
//
//                        if (position != RecyclerView.NO_POSITION) {
//                            recyclerViewInterface.onItemClick(position);
//                        }
//                    }
//                }
//            });
//        }
//    }

}