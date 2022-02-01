package com.example.pemesanerte.model.checkOld;

import android.os.Parcel;
import android.os.Parcelable;

public class CheckDataOld implements Parcelable {
    private String jumlah_penumpang;
    private String jadwal;
    private String plat_mobil;
    private String id_pemesan;
    private String asal;
    private String tujuan;
    private String tanggal;
    private String jam;
    private int status;



    public CheckDataOld(Parcel in) {
        jumlah_penumpang = in.readString();
        jadwal = in.readString();
        plat_mobil = in.readString();
        id_pemesan = in.readString();
        asal = in.readString();
        tujuan = in.readString();
        tanggal = in.readString();
        jam = in.readString();
//        jam = in.readString();
        status = in.readInt();


    }

    public static final Creator<CheckDataOld> CREATOR = new Creator<CheckDataOld>() {
        @Override
        public CheckDataOld createFromParcel(Parcel in) {
            return new CheckDataOld(in);
        }

        @Override
        public CheckDataOld[] newArray(int size) {
            return new CheckDataOld[size];
        }
    };

    public CheckDataOld() {

    }

    public String getJumlah_penumpang() {
        return jumlah_penumpang;
    }

    public void setJumlah_penumpang(String jumlah_penumpang) {
        this.jumlah_penumpang = jumlah_penumpang;
    }

    public String getJadwal() {
        return jadwal;
    }

    public String plat_mobil() {
        return plat_mobil;
    }


    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
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

    public String getId_pemesan() {
        return id_pemesan;
    }

    public void setId_pemesan(String id_pemesan) {
        this.id_pemesan = id_pemesan;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public String getStatus(){
        if (status == 1){
            return "Booking ";
        }else if (status == 2){
            return "Picked Up";
        }else if (status == 3){
            return "On Going";
        }else if (status == 4){
            return "Arrived";
        }else{
            return "Cancelled";
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(jumlah_penumpang);
        parcel.writeString(jadwal);
        parcel.writeString(plat_mobil);
        parcel.writeString(id_pemesan);
        parcel.writeString(asal);
        parcel.writeString(tujuan);
        parcel.writeString(tanggal);
        parcel.writeString(jam);
        parcel.writeInt(status);

    }
}
