package com.yoyo.navbottom.main.animeRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yoyo.navbottom.R;
import com.yoyo.navbottom.main.OnItemClickListener;

import java.util.List;

public class AnimeRecyclerAdapter extends RecyclerView.Adapter<AnimeRecyclerAdapter.ViewHolder>{
    private List<AnimeModel> animes;
    private OnItemClickListener<AnimeModel> clickListener;

    public void setAnimes(List<AnimeModel> animes) {
        this.animes = animes;
    }

    public void setClickListener(OnItemClickListener<AnimeModel> clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_anime, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(animes.get(position));
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AnimeModel anime;
        ImageView ivPoster;
        TextView tvTitle;
        TextView tvGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPoster = itemView.findViewById(R.id.iv_anime);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvGenre = itemView.findViewById(R.id.tv_genre);
        }

        public void onBind(AnimeModel anime) {
            this.anime = anime;
            ivPoster.setBackgroundResource(anime.getPoster());
            tvTitle.setText(anime.getTitle());
            tvGenre.setText(anime.getGenres());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(anime);
        }
    }
}
