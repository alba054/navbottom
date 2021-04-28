package com.yoyo.navbottom.main.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoyo.navbottom.R;
import com.yoyo.navbottom.main.CharacterDetailActivity;
import com.yoyo.navbottom.main.OnItemClickListener;

import com.yoyo.navbottom.main.characterRecycler.CharacterDatabase;
import com.yoyo.navbottom.main.characterRecycler.CharacterModel;
import com.yoyo.navbottom.main.characterRecycler.CharacterRecyclerAdapter;

public class CharacterFragment extends Fragment implements OnItemClickListener<CharacterModel> {
    private RecyclerView recyclerView;
    private CharacterRecyclerAdapter adapter;
    private CharacterDatabase databases;

    public static CharacterFragment newInstance() {
        CharacterFragment fragment = new CharacterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_character, container, false);
        recyclerView = v.findViewById(R.id.rv_characters);

        databases = new CharacterDatabase(getActivity());
        adapter = new CharacterRecyclerAdapter();
        adapter.setClickListener(this);
        adapter.setMovies(databases.getCharacter());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        recyclerView.setAdapter(adapter);
        return v;

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(CharacterModel characterModel) {
        Intent detailActivity = new Intent(getActivity(), CharacterDetailActivity.class);
        if(characterModel!=null){
            detailActivity.putExtra("CHARACTER_DETAIL", characterModel);
            startActivity(detailActivity);
        }
    }


}