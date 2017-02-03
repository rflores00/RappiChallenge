package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Im_name implements Parcelable {
    @SerializedName("label")
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Im_name(String label) {
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

    protected Im_name(Parcel in) {
        this.label = in.readString();
    }

    public static final Parcelable.Creator<Im_name> CREATOR = new Parcelable.Creator<Im_name>() {
        @Override
        public Im_name createFromParcel(Parcel source) {
            return new Im_name(source);
        }

        @Override
        public Im_name[] newArray(int size) {
            return new Im_name[size];
        }
    };
}
