package com.mohancm.popularmovies2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mohancm on 19/04/2018.
 */

public class Review implements Parcelable {
    private String author;
    private String comment;

    public Review(){

    }

    public Review(String author, String comment){
        this.author = author;
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // override writetoparcel to write strings of author and commenter
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.author);
        dest.writeString(this.comment);
    }

    protected Review(Parcel in) {
        this.author = in.readString();
        this.comment = in.readString();
    }
    // creat parcable for creactor to recive reviews
    public static final Parcelable.Creator<Review> CREATOR = new Parcelable.Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel source) {
            return new Review(source);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };
}
