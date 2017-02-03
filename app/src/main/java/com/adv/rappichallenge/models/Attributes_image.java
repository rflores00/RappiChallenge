package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attributes_image implements Parcelable {
    @SerializedName("height")
    private String height;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Attributes_image(String height) {
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.height);
    }

    protected Attributes_image(Parcel in) {
        this.height = in.readString();
    }

    public static final Parcelable.Creator<Attributes_image> CREATOR = new Parcelable.Creator<Attributes_image>() {
        @Override
        public Attributes_image createFromParcel(Parcel source) {
            return new Attributes_image(source);
        }

        @Override
        public Attributes_image[] newArray(int size) {
            return new Attributes_image[size];
        }
    };
}
