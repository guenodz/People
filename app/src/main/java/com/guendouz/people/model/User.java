package com.guendouz.people.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Guendouz on 22/11/2016.
 */

public class User implements Parcelable {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private Date dob;
    private Date registered;
    private String phone;
    private String cell;
    private ID id;
    private Picture picture;
    private String nat;

    public User() {
    }


    protected User(Parcel in) {
        gender = in.readString();
        name = in.readParcelable(Name.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
        email = in.readString();
        login = in.readParcelable(Login.class.getClassLoader());
        phone = in.readString();
        cell = in.readString();
        id = in.readParcelable(ID.class.getClassLoader());
        picture = in.readParcelable(Picture.class.getClassLoader());
        nat = in.readString();
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gender);
        dest.writeParcelable(name, flags);
        dest.writeParcelable(location, flags);
        dest.writeString(email);
        dest.writeParcelable(login, flags);
        dest.writeString(phone);
        dest.writeString(cell);
        dest.writeParcelable(id, flags);
        dest.writeParcelable(picture, flags);
        dest.writeString(nat);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


}
