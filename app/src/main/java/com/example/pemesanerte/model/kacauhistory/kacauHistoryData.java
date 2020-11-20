//package com.example.pemesanerte.model.kacauhistory;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.google.gson.annotations.SerializedName;
//
//public class kacauHistoryData implements Parcelable {
//
//    @SerializedName("id_users_feeder")
//    private String idUsersFeeder;
//
//    @SerializedName("no_hp")
//    private String noHp;
//
//    @SerializedName("tanggal_pesan")
//    private String tanggalPesan;
//
//    @SerializedName("created_at")
//    private String createdAt;
//
//    @SerializedName("detail_tujuan")
//    private String detailTujuan;
//
//    @SerializedName("id_seat")
//    private String idSeat;
//
//    @SerializedName("id_trip")
//    private String idTrip;
//
//    @SerializedName("deleted_at")
//    private Object deletedAt;
//
//    @SerializedName("nama_penumpang")
//    private String namaPenumpang;
//
//    @SerializedName("detail_asal")
//    private String detailAsal;
//
//    @SerializedName("biaya_tambahan")
//    private Object biayaTambahan;
//
//    @SerializedName("id_users_sopir")
//    private String idUsersSopir;
//
//    @SerializedName("jadwal")
//    private String jadwal;
//
//    @SerializedName("id_pesanan")
//    private String idPesanan;
//
//    @SerializedName("updated_at")
//    private String updatedAt;
//
//    @SerializedName("id_kota_asal")
//    private String idKotaAsal;
//
//    @SerializedName("id_users_operator")
//    private String idUsersOperator;
//
//    @SerializedName("id_kota_tujuan")
//    private String idKotaTujuan;
//
//    @SerializedName("jenis_kelamin")
//    private String jenisKelamin;
//
//    @SerializedName("id_users_pemesan")
//    private String idUsersPemesan;
//
//    @SerializedName("id_detail_pesanan")
//    private int idDetailPesanan;
//
//    @SerializedName("status")
//    private int status;
//
//    public kacauHistoryData(Parcel in) {
//        idUsersFeeder = in.readString();
//        noHp = in.readString();
//        tanggalPesan = in.readString();
//        createdAt = in.readString();
//        detailTujuan = in.readString();
//        idSeat = in.readString();
//        idTrip = in.readString();
//        namaPenumpang = in.readString();
//        detailAsal = in.readString();
//        idUsersSopir = in.readString();
//        jadwal = in.readString();
//        idPesanan = in.readString();
//        updatedAt = in.readString();
//        idKotaAsal = in.readString();
//        idUsersOperator = in.readString();
//        idKotaTujuan = in.readString();
//        jenisKelamin = in.readString();
//        idUsersPemesan = in.readString();
//        idDetailPesanan = in.readInt();
//        status = in.readInt();
//    }
//
//    public kacauHistoryData(){
//
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(idUsersFeeder);
//        dest.writeString(noHp);
//        dest.writeString(tanggalPesan);
//        dest.writeString(createdAt);
//        dest.writeString(detailTujuan);
//        dest.writeString(idSeat);
//        dest.writeString(idTrip);
//        dest.writeString(namaPenumpang);
//        dest.writeString(detailAsal);
//        dest.writeString(idUsersSopir);
//        dest.writeString(jadwal);
//        dest.writeString(idPesanan);
//        dest.writeString(updatedAt);
//        dest.writeString(idKotaAsal);
//        dest.writeString(idUsersOperator);
//        dest.writeString(idKotaTujuan);
//        dest.writeString(jenisKelamin);
//        dest.writeString(idUsersPemesan);
//        dest.writeInt(idDetailPesanan);
//        dest.writeInt(status);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public static final Parcelable.Creator<kacauHistoryData> CREATOR = new Creator<kacauHistoryData>() {
//        @Override
//        public kacauHistoryData createFromParcel(Parcel in) {
//            return new kacauHistoryData(in);
//        }
//
//        @Override
//        public kacauHistoryData[] newArray(int size) {
//            return new kacauHistoryData[size];
//        }
//    };
//
//    public void setIdUsersFeeder(String idUsersFeeder){
//        this.idUsersFeeder = idUsersFeeder;
//    }
//
//    public String getIdUsersFeeder(){
//        return idUsersFeeder;
//    }
//
//    public void setNoHp(String noHp){
//        this.noHp = noHp;
//    }
//
//    public String getNoHp(){
//        return noHp;
//    }
//
//    public void setTanggalPesan(String tanggalPesan){
//        this.tanggalPesan = tanggalPesan;
//    }
//
//    public String getTanggalPesan(){
//        return tanggalPesan;
//    }
//
//    public void setCreatedAt(String createdAt){
//        this.createdAt = createdAt;
//    }
//
//    public String getCreatedAt(){
//        return createdAt;
//    }
//
//    public void setDetailTujuan(String detailTujuan){
//        this.detailTujuan = detailTujuan;
//    }
//
//    public String getDetailTujuan(){
//        return detailTujuan;
//    }
//
//    public void setIdSeat(String idSeat){
//        this.idSeat = idSeat;
//    }
//
//    public String getIdSeat(){
//        return idSeat;
//    }
//
//    public void setIdTrip(String idTrip){
//        this.idTrip = idTrip;
//    }
//
//    public String getIdTrip(){
//        return idTrip;
//    }
//
//    public void setDeletedAt(Object deletedAt){
//        this.deletedAt = deletedAt;
//    }
//
//    public Object getDeletedAt(){
//        return deletedAt;
//    }
//
//    public void setNamaPenumpang(String namaPenumpang){
//        this.namaPenumpang = namaPenumpang;
//    }
//
//    public String getNamaPenumpang(){
//        return namaPenumpang;
//    }
//
//    public void setDetailAsal(String detailAsal){
//        this.detailAsal = detailAsal;
//    }
//
//    public String getDetailAsal(){
//        return detailAsal;
//    }
//
//    public void setBiayaTambahan(Object biayaTambahan){
//        this.biayaTambahan = biayaTambahan;
//    }
//
//    public Object getBiayaTambahan(){
//        return biayaTambahan;
//    }
//
//    public void setIdUsersSopir(String idUsersSopir){
//        this.idUsersSopir = idUsersSopir;
//    }
//
//    public String getIdUsersSopir(){
//        return idUsersSopir;
//    }
//
//    public void setJadwal(String jadwal){
//        this.jadwal = jadwal;
//    }
//
//    public String getJadwal(){
//        return jadwal;
//    }
//
//    public void setIdPesanan(String idPesanan){
//        this.idPesanan = idPesanan;
//    }
//
//    public String getIdPesanan(){
//        return idPesanan;
//    }
//
//    public void setUpdatedAt(String updatedAt){
//        this.updatedAt = updatedAt;
//    }
//
//    public String getUpdatedAt(){
//        return updatedAt;
//    }
//
//    public void setIdKotaAsal(String idKotaAsal){
//        this.idKotaAsal = idKotaAsal;
//    }
//
//    public String getIdKotaAsal(){
//        return idKotaAsal;
//    }
//
//    public void setIdUsersOperator(String idUsersOperator){
//        this.idUsersOperator = idUsersOperator;
//    }
//
//    public String getIdUsersOperator(){
//        return idUsersOperator;
//    }
//
//    public void setIdKotaTujuan(String idKotaTujuan){
//        this.idKotaTujuan = idKotaTujuan;
//    }
//
//    public String getIdKotaTujuan(){
//        return idKotaTujuan;
//    }
//
//    public void setJenisKelamin(String jenisKelamin){
//        this.jenisKelamin = jenisKelamin;
//    }
//
//    public String getJenisKelamin(){
//        return jenisKelamin;
//    }
//
//    public void setIdUsersPemesan(String idUsersPemesan){
//        this.idUsersPemesan = idUsersPemesan;
//    }
//
//    public String getIdUsersPemesan(){
//        return idUsersPemesan;
//    }
//
//    public void setIdDetailPesanan(int idDetailPesanan){
//        this.idDetailPesanan = idDetailPesanan;
//    }
//
//    public int getIdDetailPesanan(){
//        return idDetailPesanan;
//    }
//
//    public void setStatus(int status){
//        this.status = status;
//    }
//
//    public int getStatus(){
//        return status;
//    }
//}
