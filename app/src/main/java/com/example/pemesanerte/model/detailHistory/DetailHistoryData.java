package com.example.pemesanerte.model.detailHistory;

import com.google.gson.annotations.SerializedName;

public class DetailHistoryData {

	@SerializedName("id_pemesan")
	private String idPemesan;

	@SerializedName("no_hp")
	private Object noHp;

	@SerializedName("plat_mobil")
	private String platMobil;

	@SerializedName("order_number")
	private int orderNumber;

	@SerializedName("detail_tujuan")
	private String detailTujuan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_seat")
	private String idSeat;

	@SerializedName("id_feeder")
	private Object idFeeder;

	@SerializedName("tarif_trip")
	private int tarifTrip;

	@SerializedName("nama_penumpang")
	private String namaPenumpang;

	@SerializedName("detail_asal")
	private String detailAsal;

	@SerializedName("biaya_tambahan")
	private int biayaTambahan;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id_kota_asal")
	private String idKotaAsal;

	@SerializedName("id_kota_tujuan")
	private String idKotaTujuan;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("status")
	private String status;

	public void setIdPemesan(String idPemesan){
		this.idPemesan = idPemesan;
	}

	public String getIdPemesan(){
		return idPemesan;
	}

	public void setNoHp(Object noHp){
		this.noHp = noHp;
	}

	public Object getNoHp(){

//		return noHp;
		if (noHp == null){
			return "Phone: - ";
		}else{
			return "Phone: " +noHp;
		}

	}

	public void setPlatMobil(String platMobil){
		this.platMobil = platMobil;
	}

	public String getPlatMobil(){
		return platMobil;
	}

	public void setOrderNumber(int orderNumber){
		this.orderNumber = orderNumber;
	}

	public int getOrderNumber(){
		return orderNumber;
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
		return "Seat "+idSeat;	}

	public void setIdFeeder(Object idFeeder){
		this.idFeeder = idFeeder;
	}

	public Object getIdFeeder(){
		return idFeeder;
	}

	public void setTarifTrip(int tarifTrip){
		this.tarifTrip = tarifTrip;
	}

	public int getTarifTrip(){
		return tarifTrip;
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

	public void setBiayaTambahan(int biayaTambahan){
		this.biayaTambahan = biayaTambahan;
	}

	public String getBiayaTambahan(){

//		return biayaTambahan;

		if (biayaTambahan == 0){
			return "Additional cost(s): - ";
		}else{
			return "Additional cost(s): " +biayaTambahan;
		}
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

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
//		if (status == "1"){
//			return "Status: Booking ";
//		}else if (status == "2"){
//			return "Status: Picked Up";
//		}else if (status == "3"){
//			return "Status: On Going";
//		}else if (status == "4"){
//			return "Status: Arrived";
//		}else{
//			return "Status: Cancelled";
//		}

		switch (status){
			case "1":
				status = "Booking";
				break;
			case "2":
				status = "Picked Up";
				break;
			case "3":
				status = "On Going";
				break;
			case "4":
				status = "Arrived";
				break;
			case "5":
				status = "Cancelled";
				break;
		}
		return status;

	}
}