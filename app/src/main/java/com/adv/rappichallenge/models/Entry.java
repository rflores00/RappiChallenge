package com.adv.rappichallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruben Flores on 2/1/2017.
 */

public class Entry implements Parcelable {

    @SerializedName("im:name")
    private Im_name im_name;
    @SerializedName("im:image")
    private List<Im_image> im_image;
    @SerializedName("summary")
    private Summary summary;
    @SerializedName("im:price")
    private Im_price im_price;
    @SerializedName("im:contentType")
    private Im_contentType im_contentType;
    @SerializedName("rights")
    private Rights rights;
    @SerializedName("title")
    private Title title;
    @SerializedName("link")
    private Link link;
    @SerializedName("id")
    private Id id;
    @SerializedName("im:artist")
    private Im_artist im_artist;
    @SerializedName("category")
    private Category category;
    @SerializedName("im:releaseDate")
    private Im_releaseDate im_releaseDate;

    public Im_name getIm_name() {
        return im_name;
    }

    public void setIm_name(Im_name im_name) {
        this.im_name = im_name;
    }

    public List<Im_image> getIm_image() {
        return im_image;
    }

    public void setIm_image(List<Im_image> im_image) {
        this.im_image = im_image;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Im_price getIm_price() {
        return im_price;
    }

    public void setIm_price(Im_price im_price) {
        this.im_price = im_price;
    }

    public Im_contentType getIm_contentType() {
        return im_contentType;
    }

    public void setIm_contentType(Im_contentType im_contentType) {
        this.im_contentType = im_contentType;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Im_artist getIm_artist() {
        return im_artist;
    }

    public void setIm_artist(Im_artist im_artist) {
        this.im_artist = im_artist;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Im_releaseDate getIm_releaseDate() {
        return im_releaseDate;
    }

    public void setIm_releaseDate(Im_releaseDate im_releaseDate) {
        this.im_releaseDate = im_releaseDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.im_name, flags);
        dest.writeList(this.im_image);
        dest.writeParcelable(this.summary, flags);
        dest.writeParcelable(this.im_price, flags);
        dest.writeParcelable(this.im_contentType, flags);
        dest.writeParcelable(this.rights, flags);
        dest.writeParcelable(this.title, flags);
        dest.writeParcelable(this.link, flags);
        dest.writeParcelable(this.id, flags);
        dest.writeParcelable(this.im_artist, flags);
        dest.writeParcelable(this.category, flags);
        dest.writeParcelable(this.im_releaseDate, flags);
    }

    public Entry() {
    }

    protected Entry(Parcel in) {
        this.im_name = in.readParcelable(Im_name.class.getClassLoader());
        this.im_image = new ArrayList<Im_image>();
        in.readList(this.im_image, Im_image.class.getClassLoader());
        this.summary = in.readParcelable(Summary.class.getClassLoader());
        this.im_price = in.readParcelable(Im_price.class.getClassLoader());
        this.im_contentType = in.readParcelable(Im_contentType.class.getClassLoader());
        this.rights = in.readParcelable(Rights.class.getClassLoader());
        this.title = in.readParcelable(Title.class.getClassLoader());
        this.link = in.readParcelable(Link.class.getClassLoader());
        this.id = in.readParcelable(Id.class.getClassLoader());
        this.im_artist = in.readParcelable(Im_artist.class.getClassLoader());
        this.category = in.readParcelable(Category.class.getClassLoader());
        this.im_releaseDate = in.readParcelable(Im_releaseDate.class.getClassLoader());
    }

    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        @Override
        public Entry createFromParcel(Parcel source) {
            return new Entry(source);
        }

        @Override
        public Entry[] newArray(int size) {
            return new Entry[size];
        }
    };
}
