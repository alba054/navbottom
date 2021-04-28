package com.yoyo.navbottom.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yoyo.navbottom.R;
import com.yoyo.navbottom.main.fragments.AnimeFragment;
import com.yoyo.navbottom.main.fragments.CharacterFragment;
import com.yoyo.navbottom.main.fragments.FavoriteFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav_bottom);
        fragmentMap = new HashMap<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentMap.put(R.id.menu_item_anime, AnimeFragment.newInstance());
        fragmentMap.put(R.id.menu_item_char, CharacterFragment.newInstance());
        fragmentMap.put(R.id.menu_item_favorite, FavoriteFragment.newInstance());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_item_char);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = fragmentMap.get(item.getItemId());
        assert fragment != null;
        switch (item.getItemId()){
            case R.id.menu_item_anime:
                setActionBarTitle("Anime");
                break;
            case R.id.menu_item_favorite:
                setActionBarTitle("Favorites");
                break;
            case R.id.menu_item_char:
                setActionBarTitle("Characters");
                break;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
        return true;
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}
