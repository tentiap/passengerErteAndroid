package com.example.pemesanerte.model.search;

import android.os.Parcel;
import android.os.Parcelable;

public class InputSearch implements Parcelable {

    private String from;
    private String to;
    private String date;
    private String total;

    protected InputSearch(Parcel in) {
        from = in.readString();
        to = in.readString();
        date = in.readString();
        total = in.readString();
    }

    public InputSearch(){

    }

    public static final Creator<InputSearch> CREATOR = new Creator<InputSearch>() {
        @Override
        public InputSearch createFromParcel(Parcel in) {
            return new InputSearch(in);
        }

        @Override
        public InputSearch[] newArray(int size) {
            return new InputSearch[size];
        }
    };

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(from);
        parcel.writeString(to);
        parcel.writeString(date);
        parcel.writeString(total);
    }
}
