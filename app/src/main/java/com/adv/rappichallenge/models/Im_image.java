package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Im_image implements Parcelable {
    @SerializedName("label")
    private String label;
    @SerializedName("attributes")
    private Attributes_image attributes_image;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_image getAttributes_image() {
        return attributes_image;
    }

    public void setAttributes_image(Attributes_image attributes_image) {
        this.attributes_image = attributes_image;
    }

    public Im_image(String label, Attributes_image attributes_image) {
        this.label = label;
        this.attributes_image = attributes_image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeParcelable(this.attributes_image, flags);
    }

    protected Im_image(Parcel in) {
        this.label = in.readString();
        this.attributes_image = in.readParcelable(Attributes_image.class.getClassLoader());
    }

    public static final Parcelable.Creator<Im_image> CREATOR = new Parcelable.Creator<Im_image>() {
        @Override
        public Im_image createFromParcel(Parcel source) {
            return new Im_image(source);
        }

        @Override
        public Im_image[] newArray(int size) {
            return new Im_image[size];
        }
    };
}
