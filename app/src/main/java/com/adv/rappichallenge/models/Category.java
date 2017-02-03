package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Category implements Parcelable {
    @SerializedName("attributes")
    private Attributes_category attributes_category;

    public Attributes_category getAttributes_category() {
        return attributes_category;
    }

    public void setAttributes_category(Attributes_category attributes_category) {
        this.attributes_category = attributes_category;
    }

    public Category(Attributes_category attributes_category) {
        this.attributes_category = attributes_category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.attributes_category, flags);
    }

    protected Category(Parcel in) {
        this.attributes_category = in.readParcelable(Attributes_category.class.getClassLoader());
    }

    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
