package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attributes_contentType implements Parcelable {
    @SerializedName("term")
    private String term;
    @SerializedName("label")
    private String label;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_contentType(String term, String label) {
        this.term = term;
        this.label = label;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.term);
        dest.writeString(this.label);
    }

    protected Attributes_contentType(Parcel in) {
        this.term = in.readString();
        this.label = in.readString();
    }

    public static final Parcelable.Creator<Attributes_contentType> CREATOR = new Parcelable.Creator<Attributes_contentType>() {
        @Override
        public Attributes_contentType createFromParcel(Parcel source) {
            return new Attributes_contentType(source);
        }

        @Override
        public Attributes_contentType[] newArray(int size) {
            return new Attributes_contentType[size];
        }
    };
}
