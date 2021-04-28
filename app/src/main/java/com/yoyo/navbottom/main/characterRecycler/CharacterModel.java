package com.yoyo.navbottom.main.characterRecycler;

import android.os.Parcel;
import android.os.Parcelable;


public class CharacterModel implements Parcelable {
    public int getPoster() {
        return poster;
    }

    public String getName() {
        return name;
    }



    public static Parcelable.Creator<CharacterModel> getCREATOR() {
        return CREATOR;
    }

    private int poster;
    private String name;

    public CharacterModel() {}

    protected CharacterModel(Parcel in) {
        poster = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<CharacterModel> CREATOR = new Parcelable.Creator<CharacterModel>() {
        @Override
        public CharacterModel createFromParcel(Parcel in) {
            return new CharacterModel(in);
        }

        @Override
        public CharacterModel[] newArray(int size) {
            return new CharacterModel[size];
        }
    };

    public void setPoster(int resourceId) {
        poster = resourceId;
    }


    public void setName(String name) {
        this.name = name;
    }
}
