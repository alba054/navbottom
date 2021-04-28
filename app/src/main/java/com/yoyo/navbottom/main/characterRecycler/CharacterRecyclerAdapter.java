package com.yoyo.navbottom.main.characterRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yoyo.navbottom.R;
import com.yoyo.navbottom.main.OnItemClickListener;

import java.util.List;

public class CharacterRecyclerAdapter extends RecyclerView.Adapter<CharacterRecyclerAdapter.GridViewHolder> {
    private List<CharacterModel> characters;
    private OnItemClickListener<CharacterModel> clickListener;


    public void setMovies(List<CharacterModel> characters) {
        this.characters = characters;
    }

    public void setClickListener(OnItemClickListener<CharacterModel> clickListener) {
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_characters, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(characters.get(position).getPoster()).apply(new RequestOptions().override(350, 550)).into(holder.imgPhoto);
        holder.onBind(characters.get(position));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CharacterModel character;
        ImageView imgPhoto;
        TextView tvCharNames;

        GridViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgPhoto = itemView.findViewById(R.id.iv_poster_tv);
            tvCharNames = itemView.findViewById(R.id.tv_char_name);
        }
        void onBind(CharacterModel character) {
            this.character = character;
            imgPhoto.setImageResource(character.getPoster());
            tvCharNames.setText(character.getName());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(character);
        }
    }
}
