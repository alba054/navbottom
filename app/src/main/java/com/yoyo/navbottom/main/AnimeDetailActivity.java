package com.yoyo.navbottom.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoyo.navbottom.R;
import com.yoyo.navbottom.main.animeRecycler.AnimeModel;

public class AnimeDetailActivity extends AppCompatActivity {

    private ImageView ivPoster;
    private ImageView ivCover;
    private TextView tvTitle;
    private TextView tvGenre;
    private TextView tvSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivCover = (ImageView)findViewById(R.id.iv_anime_cover);
        ivPoster = (ImageView)findViewById(R.id.iv_anime);
        tvTitle = (TextView)findViewById(R.id.tv_title);
        tvGenre = (TextView)findViewById(R.id.tv_genre);
        tvSynopsis = (TextView)findViewById(R.id.tv_synopsis);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        AnimeModel animeModel = getIntent().getParcelableExtra("ANIME_DETAIL");

        ivCover.setImageResource(animeModel.getPoster());
        ivPoster.setBackgroundResource(animeModel.getPoster());
        tvTitle.setText(animeModel.getTitle());
        tvGenre.setText(animeModel.getGenres());
        tvSynopsis.setText(animeModel.getSynopsis());
        getSupportActionBar().setTitle(animeModel.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}