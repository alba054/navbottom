package com.yoyo.navbottom.main.characterRecycler;

import android.content.Context;
import android.content.res.TypedArray;

import com.yoyo.navbottom.R;


import java.util.ArrayList;
import java.util.List;

public class CharacterDatabase {
    private Context context;

    public CharacterDatabase(Context context) {
        this.context = context;
    }

    public List<CharacterModel> getCharacter() {
        List<CharacterModel> characters = new ArrayList<>();
        TypedArray posters = context.getResources().obtainTypedArray(R.array.charPosters);
        String[] charNames = context.getResources().getStringArray(R.array.charNames);
        for (int i = 0; i < charNames.length; i++) {
            CharacterModel character = new CharacterModel();
            character.setPoster(posters.getResourceId(i, -1));
            character.setName(charNames[i]);
            characters.add(character);
        }
        return characters;
    }
}
