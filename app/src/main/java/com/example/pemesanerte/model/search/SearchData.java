package com.example.pemesanerte.model.search;

import com.google.gson.annotations.SerializedName;

public class SearchData {

	@SerializedName("merek_mobil")
	private String merekMobil;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("kontak")
	private String kontak;

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_kota_asal")
	private String idKotaAsal;

	@SerializedName("plat_mobil")
	private String platMobil;

	@SerializedName("id_kota_tujuan")
	private String idKotaTujuan;

	@SerializedName("id_trip")
	private String idTrip;

	@SerializedName("jenis_kelamin")
	private int jenisKelamin;

	@SerializedName("id_users_sopir")
	private String idUsersSopir;

	public void setMerekMobil(String merekMobil){
		this.merekMobil = merekMobil;
	}

	public String getMerekMobil(){
		return merekMobil;
	}

	public void setJadwal(String jadwal){
		this.jadwal = jadwal;
	}

	public String getJadwal(){
		return jadwal;
	}

	public void setKontak(String kontak){
		this.kontak = kontak;
	}

	public String getKontak(){
		return kontak;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setIdKotaAsal(String idKotaAsal){
		this.idKotaAsal = idKotaAsal;
	}

	public String getIdKotaAsal(){
		return idKotaAsal;
	}

	public void setPlatMobil(String platMobil){
		this.platMobil = platMobil;
	}

	public String getPlatMobil(){
		return platMobil;
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

	public void setJenisKelamin(int jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public int getJenisKelamin(){
		return jenisKelamin;
	}

	public void setIdUsersSopir(String idUsersSopir){
		this.idUsersSopir = idUsersSopir;
	}

	public String getIdUsersSopir(){
		return idUsersSopir;
	}
}