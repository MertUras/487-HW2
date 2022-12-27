package com.example.hw2_merturas;

import android.os.Parcel;
import android.os.Parcelable;

public class Teams implements Parcelable {
    private String name;
    private String place;
    private int capacity;
    private int imgID;

    public Teams(String name, String place, int capacity, int imgID) {
        this.name = name;
        this.place = place;
        this.capacity = capacity;
        this.imgID = imgID;
    }

    public Teams() {
    }

    protected Teams(Parcel in) {
        name = in.readString();
        place = in.readString();
        capacity = in.readInt();
        imgID = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgID;
    }

    public void setImgId(int imgID) {
        this.imgID = imgID;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", capacity=" + capacity +
                ", imgID=" + imgID +
                '}';
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(place);
        dest.writeInt(capacity);
        dest.writeInt(imgID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Teams> CREATOR = new Creator<Teams>() {
        @Override
        public Teams createFromParcel(Parcel in) {
            return new Teams(in);
        }

        @Override
        public Teams[] newArray(int size) {
            return new Teams[size];
        }
    };
}
