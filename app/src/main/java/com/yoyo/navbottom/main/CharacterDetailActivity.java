package com.yoyo.navbottom.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.yoyo.navbottom.R;
import com.yoyo.navbottom.main.characterRecycler.CharacterModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class CharacterDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        civCharacterPoster = findViewById(R.id.iv_poster_detail);
        tvName = findViewById(R.id.tv_char_name);
        setContentView(R.layout.activity_character_detail);
    }

    private CircleImageView civCharacterPoster;
    private TextView tvName;


    @Override
    protected void onStart() {
        super.onStart();
        CharacterModel characterModel = getIntent().getParcelableExtra("CHARACTER_DETAIL");

        civCharacterPoster.setImageResource(characterModel.getPoster());
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