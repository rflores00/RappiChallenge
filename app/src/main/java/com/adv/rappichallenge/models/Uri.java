package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Uri implements Parcelable {
    @SerializedName("label")
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Uri(String label) {
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

    protected Uri(Parcel in) {
        this.label = in.readString();
    }

    public static final Parcelable.Creator<Uri> CREATOR = new Parcelable.Creator<Uri>() {
        @Override
        public Uri createFromParcel(Parcel source) {
            return new Uri(source);
        }

        @Override
        public Uri[] newArray(int size) {
            return new Uri[size];
        }
    };
}
