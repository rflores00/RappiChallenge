package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Im_price implements Parcelable {
    @SerializedName("label")
    private String label;
    @SerializedName("attributes")
    private Attributes_price attributes_price;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_price getAttributes_price() {
        return attributes_price;
    }

    public void setAttributes_price(Attributes_price attributes_price) {
        this.attributes_price = attributes_price;
    }

    public Im_price(String label, Attributes_price attributes_price) {
        this.label = label;
        this.attributes_price = attributes_price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeParcelable(this.attributes_price, flags);
    }

    protected Im_price(Parcel in) {
        this.label = in.readString();
        this.attributes_price = in.readParcelable(Attributes_price.class.getClassLoader());
    }

    public static final Parcelable.Creator<Im_price> CREATOR = new Parcelable.Creator<Im_price>() {
        @Override
        public Im_price createFromParcel(Parcel source) {
            return new Im_price(source);
        }

        @Override
        public Im_price[] newArray(int size) {
            return new Im_price[size];
        }
    };
}
