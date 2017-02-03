package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attributes_releaseDate implements Parcelable {
    @SerializedName("label")
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_releaseDate(String label) {
        this.label = label;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
    }

    protected Attributes_releaseDate(Parcel in) {
        this.label = in.readString();
    }

    public static final Parcelable.Creator<Attributes_releaseDate> CREATOR = new Parcelable.Creator<Attributes_releaseDate>() {
        @Override
        public Attributes_releaseDate createFromParcel(Parcel source) {
            return new Attributes_releaseDate(source);
        }

        @Override
        public Attributes_releaseDate[] newArray(int size) {
            return new Attributes_releaseDate[size];
        }
    };
}
