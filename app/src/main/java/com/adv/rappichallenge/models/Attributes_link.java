package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attributes_link implements Parcelable {
    @SerializedName("rel")
    private String rel;
    @SerializedName("type")
    private String type;
    @SerializedName("href")
    private String href;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Attributes_link(String rel, String type, String href) {
        this.rel = rel;
        this.type = type;
        this.href = href;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.rel);
        dest.writeString(this.type);
        dest.writeString(this.href);
    }

    protected Attributes_link(Parcel in) {
        this.rel = in.readString();
        this.type = in.readString();
        this.href = in.readString();
    }

    public static final Parcelable.Creator<Attributes_link> CREATOR = new Parcelable.Creator<Attributes_link>() {
        @Override
        public Attributes_link createFromParcel(Parcel source) {
            return new Attributes_link(source);
        }

        @Override
        public Attributes_link[] newArray(int size) {
            return new Attributes_link[size];
        }
    };
}
