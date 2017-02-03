package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Rights implements Parcelable {
    @SerializedName("label")
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Rights(String label) {
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

    protected Rights(Parcel in) {
        this.label = in.readString();
    }

    public static final Parcelable.Creator<Rights> CREATOR = new Parcelable.Creator<Rights>() {
        @Override
        public Rights createFromParcel(Parcel source) {
            return new Rights(source);
        }

        @Override
        public Rights[] newArray(int size) {
            return new Rights[size];
        }
    };
}
