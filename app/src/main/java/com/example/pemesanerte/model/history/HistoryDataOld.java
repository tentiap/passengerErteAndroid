//package com.example.pemesanerte.model.history;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.google.gson.annotations.SerializedName;
//
//public class HistoryDataOld implements Parcelable {
//
//	@SerializedName("jadwal")
//	private String jadwal;
//
//	@SerializedName("id_pesanan")
//	private String idPesanan;
//
//	@SerializedName("updated_at")
//	private String updatedAt;
//
//	@SerializedName("id_kota_asal")
//	private String idKotaAsal;
//
//	@SerializedName("id_users_operator")
//	private String idUsersOperator;
//
//	@SerializedName("tanggal_pesan")
//	private String tanggalPesan;
//
//	@SerializedName("created_at")
//	private String createdAt;
//
//	@SerializedName("id_kota_tujuan")
//	private String idKotaTujuan;
//
//	@SerializedName("id_trip")
//	private String idTrip;
//
//	@SerializedName("deleted_at")
//	private Object deletedAt;
//
//	@SerializedName("id_users_pemesan")
//	private String idUsersPemesan;
//
//	@SerializedName("id_users_sopir")
//	private String idUsersSopir;
//
//	protected HistoryDataOld(Parcel in) {
//		jadwal = in.readString();
//		idPesanan = in.readString();
//		updatedAt = in.readString();
//		idKotaAsal = in.readString();
//		idUsersOperator = in.readString();
//		tanggalPesan = in.readString();
//		createdAt = in.readString();
//		idKotaTujuan = in.readString();
//		idTrip = in.readString();
//		idUsersPemesan = in.readString();
//		idUsersSopir = in.readString();
//	}
//
//	public static final Creator<HistoryDataOld> CREATOR = new Creator<HistoryDataOld>() {
//		@Override
//		public HistoryDataOld createFromParcel(Parcel in) {
//			return new HistoryDataOld(in);
//		}
//
//		@Override
//		public HistoryDataOld[] newArray(int size) {
//			return new HistoryDataOld[size];
//		}
//	};
//
//	public void setJadwal(String jadwal){
//		this.jadwal = jadwal;
//	}
//
//	public String getJadwal(){
////		return jadwal;
////		SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy");
////		return sfd.format(jadwal);
//
//		String[] tanggal = jadwal.split(" ");
//		String time =  tanggal[1];
//
//		String[] jam = time.split(":");
//		return jam[0]+":"+jam[1];
//
////		DateFormat outputFormatter1 = new SimpleDateFormat("dd-MMM-yyyy");
////		String output1 = outputFormatter1.format(jadwal);
////		return output1;
//	}
//
//	public String getTanggal(){
//		String[] date = jadwal.split(" ");
//		String tgl =  date[0];
//		String[] tanggal = tgl.split("-");
//
//		final String[] monthName = {"January", "February",
//                        "March", "April", "May", "June", "July",
//                        "August", "September", "October", "November",
//                        "December"};
//		Integer months = Integer.parseInt(tanggal[1]);
//		return tanggal[2] +" "+monthName[months - 1]+ " "+tanggal[0];
//	}
//
//
//
//	public void setIdPesanan(String idPesanan){
//		this.idPesanan = idPesanan;
//	}
//
//	public String getIdPesanan(){
//		return idPesanan;
//	}
//
//	public void setUpdatedAt(String updatedAt){
//		this.updatedAt = updatedAt;
//	}
//
//	public String getUpdatedAt(){
//		return updatedAt;
//	}
//
//	public void setIdKotaAsal(String idKotaAsal){
//		this.idKotaAsal = idKotaAsal;
//
//	}
//
//	public String getIdKotaAsal(){
////		if(idKotaAsal == "K1") {
////			return "Bukittinggi";
////		}else if(idKotaAsal == "K2"){
////			return "Padang";
////		}else{
////			return "Pekanbaru";
////		}
////		return idKotaAsal;
//		switch (idKotaAsal){
//			case "K1":
//				idKotaAsal = "Bukittinggi";
//				break;
//			case "K2":
//				idKotaAsal = "Padang";
//				break;
//			case "K3":
//				idKotaAsal = "Pekanbaru";
//				break;
//		}
//		return idKotaAsal;
//	}
//
//	public void setIdUsersOperator(String idUsersOperator){
//		this.idUsersOperator = idUsersOperator;
//	}
//
//	public String getIdUsersOperator(){
//		return idUsersOperator;
//	}
//
//	public void setTanggalPesan(String tanggalPesan){
//		this.tanggalPesan = tanggalPesan;
//	}
//
//	public String getTanggalPesan(){
//		return "Date order: " +tanggalPesan;
//	}
//
//	public void setCreatedAt(String createdAt){
//		this.createdAt = createdAt;
//	}
//
//	public String getCreatedAt(){
//		return createdAt;
//	}
//
//	public void setIdKotaTujuan(String idKotaTujuan){
//		this.idKotaTujuan = idKotaTujuan;
//	}
//
//	public String getIdKotaTujuan(){
////		if(idKotaTujuan == "K1") {
////			return "Bukittinggi";
////		}else if(idKotaTujuan == "K2"){
////			return "Padang";
////		}else{
////			return "Pekanbaru";
////		}
////		if (idKotaAsal == "K1"){
////			return "Bukittinggi";
////		}else if (idKotaAsal == "K2"){
////			return "Padang";
////		}else{
////			return "Pekanbaru";
////		}
//		switch (idKotaTujuan){
//			case "K1":
//				idKotaTujuan = "Bukittinggi";
//				break;
//			case "K2":
//				idKotaTujuan = "Padang";
//				break;
//			case "K3":
//				idKotaTujuan = "Pekanbaru";
//				break;
//		}
//		return idKotaTujuan;
//	}
//
//	public void setIdTrip(String idTrip){
//		this.idTrip = idTrip;
//	}
//
//	public String getIdTrip(){
//		return idTrip;
//	}
//
//	public void setDeletedAt(Object deletedAt){
//		this.deletedAt = deletedAt;
//	}
//
//	public Object getDeletedAt(){
//		return deletedAt;
//	}
//
//	public void setIdUsersPemesan(String idUsersPemesan){
//		this.idUsersPemesan = idUsersPemesan;
//	}
//
//	public String getIdUsersPemesan(){
//		return idUsersPemesan;
//	}
//
//	public void setIdUsersSopir(String idUsersSopir){
//		this.idUsersSopir = idUsersSopir;
//	}
//
//	public String getIdUsersSopir(){
//		return idUsersSopir;
//	}
//
//	public HistoryDataOld(){
//
//    }
//
//	@Override
//	public int describeContents() {
//		return 0;
//	}
//
//	@Override
//	public void writeToParcel(Parcel parcel, int i) {
//		parcel.writeString(jadwal);
//		parcel.writeString(idPesanan);
//		parcel.writeString(updatedAt);
//		parcel.writeString(idKotaAsal);
//		parcel.writeString(idUsersOperator);
//		parcel.writeString(tanggalPesan);
//		parcel.writeString(createdAt);
//		parcel.writeString(idKotaTujuan);
//		parcel.writeString(idTrip);
//		parcel.writeString(idUsersPemesan);
//		parcel.writeString(idUsersSopir);
//	}
//}