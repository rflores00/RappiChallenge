package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ruben Flores on 2/1/2017.
 */

public class Root implements Parcelable {
    @SerializedName("feed")
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public Root(Feed feed) {
        this.feed = feed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.feed, flags);
    }

    protected Root(Parcel in) {
        this.feed = in.readParcelable(Feed.class.getClassLoader());
    }

    public static final Parcelable.Creator<Root> CREATOR = new Parcelable.Creator<Root>() {
        @Override
        public Root createFromParcel(Parcel source) {
            return new Root(source);
        }

        @Override
        public Root[] newArray(int size) {
            return new Root[size];
        }
    };
}
