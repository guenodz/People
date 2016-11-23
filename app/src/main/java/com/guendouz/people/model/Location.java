package com.guendouz.people.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Guendouz on 22/11/2016.
 */

public class Location implements Parcelable {

    private String street;
    private String city;
    private String state;
    private String postcode;

    public Location() {
    }

    protected Location(Parcel in) {
        street = in.readString();
        city = in.readString();
        state = in.readString();
        postcode = in.readString();
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(street);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(postcode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " Postcode: " + postcode;
    }
}
