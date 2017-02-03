package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Link implements Parcelable {
    @SerializedName("attributes")
    private Attributes_link attributes_link;

    public Attributes_link getAttributes_link() {
        return attributes_link;
    }

    public void setAttributes_link(Attributes_link attributes_link) {
        this.attributes_link = attributes_link;
    }

    public Link(Attributes_link attributes_link) {
        this.attributes_link = attributes_link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.attributes_link, flags);
    }

    protected Link(Parcel in) {
        this.attributes_link = in.readParcelable(Attributes_link.class.getClassLoader());
    }

    public static final Parcelable.Creator<Link> CREATOR = new Parcelable.Creator<Link>() {
        @Override
        public Link createFromParcel(Parcel source) {
            return new Link(source);
        }

        @Override
        public Link[] newArray(int size) {
            return new Link[size];
        }
    };
}
