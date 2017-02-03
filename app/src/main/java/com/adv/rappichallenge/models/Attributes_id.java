package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attributes_id implements Parcelable {
    @SerializedName("im:id")
    private String im_id;
    @SerializedName("im:bundleId")
    private String im_bundleId;

    public String getIm_id() {
        return im_id;
    }

    public void setIm_id(String im_id) {
        this.im_id = im_id;
    }

    public String getIm_bundleId() {
        return im_bundleId;
    }

    public void setIm_bundleId(String im_bundleId) {
        this.im_bundleId = im_bundleId;
    }

    public Attributes_id(String im_id, String im_bundleId) {
        this.im_id = im_id;
        this.im_bundleId = im_bundleId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.im_id);
        dest.writeString(this.im_bundleId);
    }

    protected Attributes_id(Parcel in) {
        this.im_id = in.readString();
        this.im_bundleId = in.readString();
    }

    public static final Parcelable.Creator<Attributes_id> CREATOR = new Parcelable.Creator<Attributes_id>() {
        @Override
        public Attributes_id createFromParcel(Parcel source) {
            return new Attributes_id(source);
        }

        @Override
        public Attributes_id[] newArray(int size) {
            return new Attributes_id[size];
        }
    };
}
