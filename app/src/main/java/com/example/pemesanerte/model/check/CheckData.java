package com.example.pemesanerte.model.check;

import android.os.Parcel;
import android.os.Parcelable;

public class CheckData implements Parcelable {
    private String jumlah_penumpang;
    private String id_trip;
    private String id_users_pemesan;
    private String asal;
    private String tujuan;
    private String tanggal;
    private String jam;

    public CheckData(Parcel in) {
        jumlah_penumpang = in.readString();
        id_trip = in.readString();
        id_users_pemesan = in.readString();
        asal = in.readString();
        tujuan = in.readString();
        tanggal = in.readString();
        jam = in.readString();
    }

    public static final Creator<CheckData> CREATOR = new Creator<CheckData>() {
        @Override
        public CheckData createFromParcel(Parcel in) {
            return new CheckData(in);
        }

        @Override
        public CheckData[] newArray(int size) {
            return new CheckData[size];
        }
    };

    public CheckData() {

    }

    public String getJumlah_penumpang() {
        return jumlah_penumpang;
    }

    public void setJumlah_penumpang(String jumlah_penumpang) {
        this.jumlah_penumpang = jumlah_penumpang;
    }

    public String getId_trip() {
        return id_trip;
    }

    public void setId_trip(String id_trip) {
        this.id_trip = id_trip;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getId_users_pemesan() {
        return id_users_pemesan;
    }

    public void setId_users_pemesan(String id_users_pemesan) {
        this.id_users_pemesan = id_users_pemesan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(jumlah_penumpang);
        parcel.writeString(id_trip);
        parcel.writeString(id_users_pemesan);
        parcel.writeString(asal);
        parcel.writeString(tujuan);
        parcel.writeString(tanggal);
        parcel.writeString(jam);
    }
}
