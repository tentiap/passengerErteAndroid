package com.example.pemesanerte.model.pesanan;

import com.google.gson.annotations.SerializedName;

public class PesananData {

	@SerializedName("id_pemesan")
	private String idPemesan;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("plat_mobil")
	private String platMobil;

	@SerializedName("tanggal_pesan")
	private String tanggalPesan;

	@SerializedName("created_at")
	private String createdAt;

	public void setIdPemesan(String idPemesan){
		this.idPemesan = idPemesan;
	}

	public String getIdPemesan(){
		return idPemesan;
	}

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

	public void setPlatMobil(String platMobil){
		this.platMobil = platMobil;
	}

	public String getPlatMobil(){
		return platMobil;
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
}