package com.yoyo.navbottom.main.animeRecycler;

import android.content.Context;
import android.content.res.TypedArray;

import com.yoyo.navbottom.R;

import java.util.ArrayList;
import java.util.List;

public class AnimeDataBase {
    private Context context;

    public AnimeDataBase(Context context) {
        this.context = context;
    }

    public List<AnimeModel> getAnime() {
        List<AnimeModel> animes = new ArrayList<>();
        TypedArray posters = context.getResources().obtainTypedArray(R.array.posters);
        String[] titles = context.getResources().getStringArray(R.array.titles);
        String[] genres = context.getResources().getStringArray(R.array.genres);
        String[] synopsis = context.getResources().getStringArray(R.array.synopsis);
        for (int i = 0; i < titles.length; i++) {
            AnimeModel anime = new AnimeModel();
            anime.setPoster(posters.getResourceId(i, -1));
            anime.setTitle(titles[i]);
            anime.setGenres(genres[i]);
            anime.setSynopsis(synopsis[i]);
            animes.add(anime);
        }
        return animes;
    }
}
