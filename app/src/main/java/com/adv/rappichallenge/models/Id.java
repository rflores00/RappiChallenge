package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Id implements Parcelable {
    @SerializedName("label")
    private String label;
    @SerializedName("attributes")
    private Attributes_id attributes_id;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_id getAttributes_id() {
        return attributes_id;
    }

    public void setAttributes_id(Attributes_id attributes_id) {
        this.attributes_id = attributes_id;
    }

    public Id(String label, Attributes_id attributes_id) {
        this.label = label;
        this.attributes_id = attributes_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeParcelable(this.attributes_id, flags);
    }

    protected Id(Parcel in) {
        this.label = in.readString();
        this.attributes_id = in.readParcelable(Attributes_id.class.getClassLoader());
    }

    public static final Parcelable.Creator<Id> CREATOR = new Parcelable.Creator<Id>() {
        @Override
        public Id createFromParcel(Parcel source) {
            return new Id(source);
        }

        @Override
        public Id[] newArray(int size) {
            return new Id[size];
        }
    };
}
