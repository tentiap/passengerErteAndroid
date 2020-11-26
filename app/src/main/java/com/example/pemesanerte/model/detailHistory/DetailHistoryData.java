package com.example.pemesanerte.model.detailHistory;

import com.google.gson.annotations.SerializedName;

public class DetailHistoryData {

	@SerializedName("id_users_feeder")
	private String idUsersFeeder;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("detail_tujuan")
	private String detailTujuan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_seat")
	private String idSeat;

	@SerializedName("id_trip")
	private String idTrip;

	@SerializedName("nama_penumpang")
	private String namaPenumpang;

	@SerializedName("detail_asal")
	private String detailAsal;

	@SerializedName("biaya_tambahan")
	private Object biayaTambahan;

	@SerializedName("id_users_sopir")
	private String idUsersSopir;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("id_pesanan")
	private String idPesanan;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id_kota_asal")
	private String idKotaAsal;

	@SerializedName("id_users_operator")
	private String idUsersOperator;

	@SerializedName("id_kota_tujuan")
	private String idKotaTujuan;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("id_detail_pesanan")
	private int idDetailPesanan;

	@SerializedName("status")
	private int status;

	public void setIdUsersFeeder(String idUsersFeeder){
		this.idUsersFeeder = idUsersFeeder;
	}

	public String getIdUsersFeeder(){
		return idUsersFeeder;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return "Phone: " +noHp;
	}

	public void setDetailTujuan(String detailTujuan){
		this.detailTujuan = detailTujuan;
	}

	public String getDetailTujuan(){
		return "To: " +detailTujuan;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIdSeat(String idSeat){
		this.idSeat = idSeat;
	}

	public String getIdSeat(){
		return "Seat "+idSeat;
	}

	public void setIdTrip(String idTrip){
		this.idTrip = idTrip;
	}

	public String getIdTrip(){
		return idTrip;
	}

	public void setNamaPenumpang(String namaPenumpang){
		this.namaPenumpang = namaPenumpang;
	}

	public String getNamaPenumpang(){
		return namaPenumpang;
	}

	public void setDetailAsal(String detailAsal){
		this.detailAsal = detailAsal;
	}

	public String getDetailAsal(){
		return "From: " +detailAsal;
	}

	public void setBiayaTambahan(Object biayaTambahan){
		this.biayaTambahan = biayaTambahan;
	}

	public Object getBiayaTambahan(){
		return "Additional cost(s): " +biayaTambahan;
	}

	public void setIdUsersSopir(String idUsersSopir){
		this.idUsersSopir = idUsersSopir;
	}

	public String getIdUsersSopir(){
		return idUsersSopir;
	}

	public void setJadwal(String jadwal){
		this.jadwal = jadwal;
	}

	public String getJadwal(){
		return jadwal;
	}

	public void setIdPesanan(String idPesanan){
		this.idPesanan = idPesanan;
	}

	public String getIdPesanan(){
		return idPesanan;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setIdKotaAsal(String idKotaAsal){
		this.idKotaAsal = idKotaAsal;
	}

	public String getIdKotaAsal(){
		return idKotaAsal;
	}

	public void setIdUsersOperator(String idUsersOperator){
		this.idUsersOperator = idUsersOperator;
	}

	public String getIdUsersOperator(){
		return idUsersOperator;
	}

	public void setIdKotaTujuan(String idKotaTujuan){
		this.idKotaTujuan = idKotaTujuan;
	}

	public String getIdKotaTujuan(){
		return idKotaTujuan;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return "("+jenisKelamin+")";
	}

	public void setIdDetailPesanan(int idDetailPesanan){
		this.idDetailPesanan = idDetailPesanan;
	}

	public int getIdDetailPesanan(){
		return idDetailPesanan;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}