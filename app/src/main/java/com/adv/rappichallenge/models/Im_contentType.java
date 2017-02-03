package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Im_contentType implements Parcelable {
    @SerializedName("attributes")
    private Attributes_contentType attributes_contentType;

    public Attributes_contentType getAttributes_contentType() {
        return attributes_contentType;
    }

    public void setAttributes_contentType(Attributes_contentType attributes_contentType) {
        this.attributes_contentType = attributes_contentType;
    }

    public Im_contentType(Attributes_contentType attributes_contentType) {
        this.attributes_contentType = attributes_contentType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.attributes_contentType, flags);
    }

    protected Im_contentType(Parcel in) {
        this.attributes_contentType = in.readParcelable(Attributes_contentType.class.getClassLoader());
    }

    public static final Parcelable.Creator<Im_contentType> CREATOR = new Parcelable.Creator<Im_contentType>() {
        @Override
        public Im_contentType createFromParcel(Parcel source) {
            return new Im_contentType(source);
        }

        @Override
        public Im_contentType[] newArray(int size) {
            return new Im_contentType[size];
        }
    };
}
