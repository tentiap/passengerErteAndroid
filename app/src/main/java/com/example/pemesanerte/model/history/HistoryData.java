package com.example.pemesanerte.model.history;

import com.google.gson.annotations.SerializedName;

public class HistoryData {

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

	@SerializedName("tanggal_pesan")
	private String tanggalPesan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_kota_tujuan")
	private String idKotaTujuan;

	@SerializedName("id_trip")
	private String idTrip;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_users_pemesan")
	private String idUsersPemesan;

	@SerializedName("id_users_sopir")
	private String idUsersSopir;

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
//		if(idKotaAsal == "K1") {
//			return "Bukittinggi";
//		}else if(idKotaAsal == "K2"){
//			return "Padang";
//		}else if (idKotaAsal == "K3"){
//			return "Pekanbaru";
//		}
		return idKotaAsal;
	}

	public void setIdUsersOperator(String idUsersOperator){
		this.idUsersOperator = idUsersOperator;
	}

	public String getIdUsersOperator(){
		return idUsersOperator;
	}

	public void setTanggalPesan(String tanggalPesan){
		this.tanggalPesan = tanggalPesan;
	}

	public String getTanggalPesan(){
		return tanggalPesan;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIdKotaTujuan(String idKotaTujuan){
		this.idKotaTujuan = idKotaTujuan;
	}

	public String getIdKotaTujuan(){
		return idKotaTujuan;
	}

	public void setIdTrip(String idTrip){
		this.idTrip = idTrip;
	}

	public String getIdTrip(){
		return idTrip;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setIdUsersPemesan(String idUsersPemesan){
		this.idUsersPemesan = idUsersPemesan;
	}

	public String getIdUsersPemesan(){
		return idUsersPemesan;
	}

	public void setIdUsersSopir(String idUsersSopir){
		this.idUsersSopir = idUsersSopir;
	}

	public String getIdUsersSopir(){
		return idUsersSopir;
	}
}