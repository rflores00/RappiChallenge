package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Im_releaseDate implements Parcelable {
    @SerializedName("label")
    private String label;
    @SerializedName("attributes")
    private Attributes_releaseDate attributes_releaseDate;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_releaseDate getAttributes_releaseDate() {
        return attributes_releaseDate;
    }

    public void setAttributes_releaseDate(Attributes_releaseDate attributes_releaseDate) {
        this.attributes_releaseDate = attributes_releaseDate;
    }

    public Im_releaseDate(String label, Attributes_releaseDate attributes_releaseDate) {
        this.label = label;
        this.attributes_releaseDate = attributes_releaseDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeParcelable(this.attributes_releaseDate, flags);
    }

    protected Im_releaseDate(Parcel in) {
        this.label = in.readString();
        this.attributes_releaseDate = in.readParcelable(Attributes_releaseDate.class.getClassLoader());
    }

    public static final Parcelable.Creator<Im_releaseDate> CREATOR = new Parcelable.Creator<Im_releaseDate>() {
        @Override
        public Im_releaseDate createFromParcel(Parcel source) {
            return new Im_releaseDate(source);
        }

        @Override
        public Im_releaseDate[] newArray(int size) {
            return new Im_releaseDate[size];
        }
    };
}
