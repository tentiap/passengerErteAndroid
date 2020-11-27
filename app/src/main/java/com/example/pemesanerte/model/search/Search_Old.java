//package com.example.pemesanerte.model.search;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.google.gson.annotations.SerializedName;
//
//public class Search implements Parcelable {
//
//    @SerializedName("id_trip")
//    private String idTrip;
//
//    @SerializedName("id_users_operator")
//    private String idUsersOperator;
//
//    @SerializedName("nama")
//    private String nama;
//
//    @SerializedName("id_users_sopir")
//    private String idUsersSopir;
//
//    @SerializedName("id_kota_asal")
//    private String idKotaAsal;
//
//    @SerializedName("id_kota_tujuan")
//    private String idKotaTujuan;
//
//    @SerializedName("jadwal")
//    private String jadwal;
//
//    @SerializedName("created_at")
//    private String createdAt;
//
//    @SerializedName("updated_at")
//    private String updatedAt;
//
//    public Search(Parcel in) {
//        idTrip = in.readString();
//        idUsersOperator = in.readString();
//        idUsersSopir = in.readString();
//        nama = in.readString();
//        idKotaAsal = in.readString();
//        idKotaTujuan = in.readString();
//        jadwal = in.readString();
//        createdAt = in.readString();
//        updatedAt = in.readString();
//    }
//
//    public static final Creator<Search> CREATOR = new Creator<Search>() {
//        @Override
//        public Search createFromParcel(Parcel in) {
//            return new Search(in);
//        }
//
//        @Override
//        public Search[] newArray(int size) {
//            return new Search[size];
//        }
//    };
//
//    public String getIdTrip() {
//        return idTrip;
//    }
//
//    public void setIdTrip(String idTrip) {
//        this.idTrip = idTrip;
//    }
//
//    public String getIdUsersOperator() {
//        return idUsersOperator;
//    }
//
//    public void setIdUsersOperator(String idUsersOperator) {
//        this.idUsersOperator = idUsersOperator;
//    }
//
//    public String getIdUsersSopir() {
//        return idUsersSopir;
//    }
//
//    public void setIdUsersSopir(String idUsersSopir) {
//        this.idUsersSopir = idUsersSopir;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//
//    public String getIdKotaAsal() {
//        return idKotaAsal;
//    }
//
//    public void setIdKotaAsal(String idKotaAsal) {
//        this.idKotaAsal = idKotaAsal;
//    }
//
//    public String getIdKotaTujuan() {
//        return idKotaTujuan;
//    }
//
//    public void setIdKotaTujuan(String idKotaTujuan) {
//        this.idKotaTujuan = idKotaTujuan;
//    }
//
//    public String getJadwal() {
//        return jadwal;
//    }
//
//    public void setJadwal(String jadwal) {
//        this.jadwal = jadwal;
//    }
//
//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(String updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public Search(){
//
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeString(idTrip);
//        parcel.writeString(idUsersOperator);
//        parcel.writeString(idUsersSopir);
//        parcel.writeString(nama);
//        parcel.writeString(idKotaAsal);
//        parcel.writeString(idKotaTujuan);
//        parcel.writeString(jadwal);
//        parcel.writeString(createdAt);
//        parcel.writeString(updatedAt);
//    }
//}