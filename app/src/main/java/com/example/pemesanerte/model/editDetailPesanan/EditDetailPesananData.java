package com.example.pemesanerte.model.editDetailPesanan;

import com.google.gson.annotations.SerializedName;

public class EditDetailPesananData {

	@SerializedName("id_pemesan")
	private String idPemesan;

	@SerializedName("no_hp")
	private String noHp;

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
	private String idFeeder;

	@SerializedName("nama_penumpang")
	private String namaPenumpang;

	@SerializedName("detail_asal")
	private String detailAsal;

	@SerializedName("biaya_tambahan")
	private Object biayaTambahan;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("updated_at")
	private String updatedAt;

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

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
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
		return detailTujuan;
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
		return idSeat;
	}

	public void setIdFeeder(String idFeeder){
		this.idFeeder = idFeeder;
	}

	public String getIdFeeder(){
		return idFeeder;
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
		return detailAsal;
	}

	public void setBiayaTambahan(Object biayaTambahan){
		this.biayaTambahan = biayaTambahan;
	}

	public Object getBiayaTambahan(){
		return biayaTambahan;
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
//		return status;
//		if (status == "1"){
//			return "Booking ";
//		}else if (status == "2"){
//			return "Picked Up";
//		}else if (status == "3"){
//			return "On Going";
//		}else if (status == "4"){
//			return "Arrived";
//		}else{
//			return "Cancelled";
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