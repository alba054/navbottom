package com.yoyo.navbottom.main.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoyo.navbottom.R;
import com.yoyo.navbottom.main.AnimeDetailActivity;
import com.yoyo.navbottom.main.OnItemClickListener;
import com.yoyo.navbottom.main.animeRecycler.AnimeDataBase;
import com.yoyo.navbottom.main.animeRecycler.AnimeModel;
import com.yoyo.navbottom.main.animeRecycler.AnimeRecyclerAdapter;


public class AnimeFragment extends Fragment implements OnItemClickListener<AnimeModel> {

    private RecyclerView recyclerView;
    private AnimeRecyclerAdapter adapter;
    private AnimeDataBase databases;

    public static AnimeFragment newInstance() {
        AnimeFragment fragment = new AnimeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_anime, container, false);
        recyclerView = v.findViewById(R.id.rv_animes);
        databases = new AnimeDataBase(getActivity());
        adapter = new AnimeRecyclerAdapter();
        adapter.setClickListener(this);
        adapter.setAnimes(databases.getAnime());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(AnimeModel animeModel) {
        Intent detailActivity = new Intent(getActivity(), AnimeDetailActivity.class);
        if(animeModel !=null){
            detailActivity.putExtra("ANIME_DETAIL", animeModel);
            startActivity(detailActivity);
        }
    }
}