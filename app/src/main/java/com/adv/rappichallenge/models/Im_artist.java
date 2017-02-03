package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Im_artist implements Parcelable {
    @SerializedName("label")
    private String label;
    @SerializedName("attributes")
    private Attributes_artist attributes_artist;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_artist getAttributes_artist() {
        return attributes_artist;
    }

    public void setAttributes_artist(Attributes_artist attributes_artist) {
        this.attributes_artist = attributes_artist;
    }

    public Im_artist(String label, Attributes_artist attributes_artist) {
        this.label = label;
        this.attributes_artist = attributes_artist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeParcelable(this.attributes_artist, flags);
    }

    protected Im_artist(Parcel in) {
        this.label = in.readString();
        this.attributes_artist = in.readParcelable(Attributes_artist.class.getClassLoader());
    }

    public static final Parcelable.Creator<Im_artist> CREATOR = new Parcelable.Creator<Im_artist>() {
        @Override
        public Im_artist createFromParcel(Parcel source) {
            return new Im_artist(source);
        }

        @Override
        public Im_artist[] newArray(int size) {
            return new Im_artist[size];
        }
    };
}
