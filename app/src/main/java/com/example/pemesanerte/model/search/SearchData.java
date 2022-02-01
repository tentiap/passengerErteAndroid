package com.example.pemesanerte.model.search;

import com.google.gson.annotations.SerializedName;

public class SearchData {

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("plat_mobil")
	private String platMobil;

	@SerializedName("id_kota_asal")
	private String idKotaAsal;

	@SerializedName("id_kota_tujuan")
	private String idKotaTujuan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("tarif_trip")
	private int tarifTrip;

	public void setJadwal(String jadwal){
		this.jadwal = jadwal;
	}

	public String getJadwal(){
		String[] tanggal = jadwal.split(" ");
		String time =  tanggal[1];

		String[] jam = time.split(":");
		return jam[0]+":"+jam[1];
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setPlatMobil(String platMobil){
		this.platMobil = platMobil;
	}

	public String getPlatMobil(){
		return platMobil;
	}

	public void setIdKotaAsal(String idKotaAsal){
		this.idKotaAsal = idKotaAsal;
	}

	public String getIdKotaAsal(){
		return idKotaAsal;
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

	public void setTarifTrip(int tarifTrip){
		this.tarifTrip = tarifTrip;
	}

	public int getTarifTrip(){
		return tarifTrip;
	}
}