package com.yoyo.navbottom.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoyo.navbottom.R;
import com.yoyo.navbottom.main.characterRecycler.CharacterModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class CharacterDetailActivity extends AppCompatActivity {
    private ImageView civCharacterPoster;
    private TextView tvName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        civCharacterPoster = (ImageView)findViewById(R.id.iv_poster_detail);
        tvName = (TextView)findViewById(R.id.tv_char_name);
        setContentView(R.layout.activity_character_detail);
    }

    @Override
    protected void onStart() {
        super.onStart();
        civCharacterPoster = (ImageView)findViewById(R.id.iv_poster_detail);
        tvName = (TextView)findViewById(R.id.tv_char_name);
        CharacterModel characterModel = getIntent().getParcelableExtra("CHARACTER_DETAIL");
        Log.d("debug :", Integer.toString(characterModel.getPoster()));

        tvName.setText(characterModel.getName());
        getSupportActionBar().setTitle(characterModel.getName());
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