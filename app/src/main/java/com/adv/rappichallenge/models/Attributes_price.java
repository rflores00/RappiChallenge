package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attributes_price implements Parcelable {
    @SerializedName("amount")
    private String amount;
    @SerializedName("currency")
    private String currency;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Attributes_price(String amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.amount);
        dest.writeString(this.currency);
    }

    protected Attributes_price(Parcel in) {
        this.amount = in.readString();
        this.currency = in.readString();
    }

    public static final Parcelable.Creator<Attributes_price> CREATOR = new Parcelable.Creator<Attributes_price>() {
        @Override
        public Attributes_price createFromParcel(Parcel source) {
            return new Attributes_price(source);
        }

        @Override
        public Attributes_price[] newArray(int size) {
            return new Attributes_price[size];
        }
    };
}
