package com.example.pemesanerte.model.search;

import com.google.gson.annotations.SerializedName;

public class SearchData {

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id_kota_asal")
	private String idKotaAsal;

	@SerializedName("id_users_operator")
	private String idUsersOperator;

	@SerializedName("id_kota_tujuan")
	private String idKotaTujuan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_trip")
	private String idTrip;

	@SerializedName("id_users_sopir")
	private String idUsersSopir;

	public void setJadwal(String jadwal){
		this.jadwal = jadwal;
	}

	public String getJadwal(){
		return jadwal;
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

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIdTrip(String idTrip){
		this.idTrip = idTrip;
	}

	public String getIdTrip(){
		return idTrip;
	}

	public void setIdUsersSopir(String idUsersSopir){
		this.idUsersSopir = idUsersSopir;
	}

	public String getIdUsersSopir(){
		return idUsersSopir;
	}
}