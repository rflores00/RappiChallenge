package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attributes_category implements Parcelable {
    @SerializedName("im:id")
    private String im_id;
    @SerializedName("term")
    private String term;
    @SerializedName("scheme")
    private String scheme;
    @SerializedName("label")
    private String label;

    public String getIm_id() {
        return im_id;
    }

    public void setIm_id(String im_id) {
        this.im_id = im_id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_category(String im_id, String term, String scheme, String label) {
        this.im_id = im_id;
        this.term = term;
        this.scheme = scheme;
        this.label = label;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.im_id);
        dest.writeString(this.term);
        dest.writeString(this.scheme);
        dest.writeString(this.label);
    }

    protected Attributes_category(Parcel in) {
        this.im_id = in.readString();
        this.term = in.readString();
        this.scheme = in.readString();
        this.label = in.readString();
    }

    public static final Parcelable.Creator<Attributes_category> CREATOR = new Parcelable.Creator<Attributes_category>() {
        @Override
        public Attributes_category createFromParcel(Parcel source) {
            return new Attributes_category(source);
        }

        @Override
        public Attributes_category[] newArray(int size) {
            return new Attributes_category[size];
        }
    };
}
