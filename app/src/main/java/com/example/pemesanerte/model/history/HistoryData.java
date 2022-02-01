package com.example.pemesanerte.model.history;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class HistoryData implements Parcelable {

	@SerializedName("id_pemesan")
	private String idPemesan;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("plat_mobil")
	private String platMobil;

	@SerializedName("id_kota_asal")
	private String idKotaAsal;

	@SerializedName("tanggal_pesan")
	private String tanggalPesan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_kota_tujuan")
	private String idKotaTujuan;

	@SerializedName("tarif_trip")
	private int tarifTrip;

	@SerializedName("id_pengurus")
	private String idPengurus;

	protected HistoryData(Parcel in) {
		idPemesan = in.readString();
		jadwal = in.readString();
		updatedAt = in.readString();
		platMobil = in.readString();
		idKotaAsal = in.readString();
		tanggalPesan = in.readString();
		createdAt = in.readString();
		idKotaTujuan = in.readString();
		tarifTrip = in.readInt();
		idPengurus = in.readString();
	}

	public static final Creator<HistoryData> CREATOR = new Creator<HistoryData>() {
		@Override
		public HistoryData createFromParcel(Parcel in) {
			return new HistoryData(in);
		}

		@Override
		public HistoryData[] newArray(int size) {
			return new HistoryData[size];
		}
	};

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
//		return jadwal;

		String[] tanggal = jadwal.split(" ");
		String time =  tanggal[1];

		String[] jam = time.split(":");
		return jam[0]+":"+jam[1];
	}

	public String getJadwalFormatted(){
		return jadwal;
	}

	public String getTanggal(){
		String[] date = jadwal.split(" ");
		String tgl =  date[0];
		String[] tanggal = tgl.split("-");

		final String[] monthName = {"January", "February",
				"March", "April", "May", "June", "July",
				"August", "September", "October", "November",
				"December"};
		Integer months = Integer.parseInt(tanggal[1]);
		return tanggal[2] +" "+monthName[months - 1]+ " "+tanggal[0];
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
//		return idKotaAsal;

		switch (idKotaAsal){
			case "K1":
				idKotaAsal = "Bukittinggi";
				break;
			case "K2":
				idKotaAsal = "Padang";
				break;
			case "K3":
				idKotaAsal = "Pekanbaru";
				break;
		}
		return idKotaAsal;
	}

	public void setTanggalPesan(String tanggalPesan){
		this.tanggalPesan = tanggalPesan;
	}

	public String getTanggalPesan(){
		return "Date order: " +tanggalPesan;
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
//		return idKotaTujuan;
		switch (idKotaTujuan){
			case "K1":
				idKotaTujuan = "Bukittinggi";
				break;
			case "K2":
				idKotaTujuan = "Padang";
				break;
			case "K3":
				idKotaTujuan = "Pekanbaru";
				break;
		}
		return idKotaTujuan;
	}

	public void setTarifTrip(int tarifTrip){
		this.tarifTrip = tarifTrip;
	}

	public int getTarifTrip(){
		return tarifTrip;
	}

	public void setIdPengurus(String idPengurus){
		this.idPengurus = idPengurus;
	}

	public String getIdPengurus(){
		return idPengurus;
	}

	public HistoryData(){

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(idPemesan);
		parcel.writeString(jadwal);
		parcel.writeString(updatedAt);
		parcel.writeString(platMobil);
		parcel.writeString(idKotaAsal);
		parcel.writeString(tanggalPesan);
		parcel.writeString(createdAt);
		parcel.writeString(idKotaTujuan);
		parcel.writeInt(tarifTrip);
		parcel.writeString(idPengurus);
	}
}