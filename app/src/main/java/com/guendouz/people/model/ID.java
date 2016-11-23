package com.guendouz.people.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Guendouz on 22/11/2016.
 */

public class ID implements Parcelable {

    private String name;
    private String value;

    public ID() {
    }

    protected ID(Parcel in) {
        name = in.readString();
        value = in.readString();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ID> CREATOR = new Creator<ID>() {
        @Override
        public ID createFromParcel(Parcel in) {
            return new ID(in);
        }

        @Override
        public ID[] newArray(int size) {
            return new ID[size];
        }
    };
}
