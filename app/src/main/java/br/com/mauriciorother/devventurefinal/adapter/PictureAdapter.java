package br.com.mauriciorother.devventurefinal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.mauriciorother.devventurefinal.R;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.PictureViewHolder> {

    private List<String> pictureList;

    public PictureAdapter(List<String> pictureList) {
        this.pictureList = pictureList;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.list_item_picture, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {
        Glide.with(holder.imageView.getContext())
                .load(pictureList.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }

    static class PictureViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_cat);
        }
    }
}
