package com.example.likestat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.likestat.R;
import com.example.likestat.model.Likes;
import com.squareup.picasso.Picasso;

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.LikeViewHolder> {

    private Context context;
    private Likes likes;

    public LikeAdapter(Likes likes) {
        this.likes = likes;
    }

    @Override
    public int getItemCount() {
        return likes.getLikes().size();
    }

    @NonNull
    @Override
    public LikeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new LikeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeViewHolder holder, int position) {
        holder.textView.setText(likes.getLikes().get(position).getNickname());

        Picasso.with(context)
                .load(likes.getLikes().get(position).getAvatarImage().getUrlSmall())
                .placeholder(R.drawable.circle_shape)
                .error(R.drawable.notloaded)
                .into(holder.imageView);
    }

    public static class LikeViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public LikeViewHolder(View view) {
            super(view);
            this.textView = view.findViewById(R.id.textView);
            this.imageView = view.findViewById(R.id.imageView);
        }
    }
}
