package com.denztri.denzsakura.ui.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.denztri.denzsakura.R;
import com.denztri.denzsakura.db.Activity;
import com.denztri.denzsakura.ui.daily.tab.ActivityListAdapter;

import java.util.List;

import retrofit2.Call;

public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> {
    private final Context context;
    private List<GalleryList> galleryLists;

    public GalleryListAdapter(Context context){
        this.context = context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setGalleryLists(List<GalleryList> list){
        this.galleryLists = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GalleryListAdapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_gallery_row, parent, false);

        return new GalleryListAdapter.GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryListAdapter.GalleryViewHolder holder, int position) {
        String url = this.galleryLists.get(position).getUrl();
        Glide.with(context)
                .load(url)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return this.galleryLists.size();
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.gallery_recycle_img);
        }
    }
}
