package com.yoyo.navbottom.main.animeRecycler;

import android.os.Parcel;
import android.os.Parcelable;

public class AnimeModel implements Parcelable {
    public int getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public String getGenres() {
        return genres;
    }

    public static Creator<AnimeModel> getCREATOR() {
        return CREATOR;
    }

    private int poster;
    private String title;
    private String genres;

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    private String synopsis;

    public AnimeModel() {}

    protected AnimeModel(Parcel in) {
        poster = in.readInt();
        title = in.readString();
        genres = in.readString();
        synopsis = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(title);
        dest.writeString(genres);
        dest.writeString(synopsis);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AnimeModel> CREATOR = new Creator<AnimeModel>() {
        @Override
        public AnimeModel createFromParcel(Parcel in) {
            return new AnimeModel(in);
        }

        @Override
        public AnimeModel[] newArray(int size) {
            return new AnimeModel[size];
        }
    };

    public void setPoster(int resourceId) {
        poster = resourceId;
    }

    public void setGenres(String genre) {
        this.genres = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
