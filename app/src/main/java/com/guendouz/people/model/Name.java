package com.guendouz.people.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Guendouz on 22/11/2016.
 */

public class Name implements Parcelable {

    private String title;
    private String first;
    private String last;

    public Name() {
    }

    protected Name(Parcel in) {
        title = in.readString();
        first = in.readString();
        last = in.readString();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return Character.toString(title.charAt(0))
                .toUpperCase() + title.substring(1) + " " + first + " " + last;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(first);
        dest.writeString(last);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Name> CREATOR = new Creator<Name>() {
        @Override
        public Name createFromParcel(Parcel in) {
            return new Name(in);
        }

        @Override
        public Name[] newArray(int size) {
            return new Name[size];
        }
    };
}
