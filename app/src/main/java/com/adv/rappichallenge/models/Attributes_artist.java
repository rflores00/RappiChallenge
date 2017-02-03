package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attributes_artist implements Parcelable {
    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Attributes_artist(String href) {
        this.href = href;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.href);
    }

    protected Attributes_artist(Parcel in) {
        this.href = in.readString();
    }

    public static final Parcelable.Creator<Attributes_artist> CREATOR = new Parcelable.Creator<Attributes_artist>() {
        @Override
        public Attributes_artist createFromParcel(Parcel source) {
            return new Attributes_artist(source);
        }

        @Override
        public Attributes_artist[] newArray(int size) {
            return new Attributes_artist[size];
        }
    };
}
