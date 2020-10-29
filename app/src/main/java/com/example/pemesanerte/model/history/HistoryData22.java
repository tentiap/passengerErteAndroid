//package com.example.pemesanerte.model.history;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.google.gson.annotations.SerializedName;
//
//public class HistoryData22 implements Parcelable {
//
//	@SerializedName("id_pesanan")
//	private String idPesanan;
//
//	@SerializedName("updated_at")
//	private String updatedAt;
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
//	@SerializedName("id_trip")
//	private String idTrip;
//
//	@SerializedName("deleted_at")
//	private Object deletedAt;
//
//	@SerializedName("id_users_pemesan")
//	private String idUsersPemesan;
//
//	protected HistoryData22(Parcel in) {
//		idPesanan = in.readString();
//		updatedAt = in.readString();
//		idUsersOperator = in.readString();
//		tanggalPesan = in.readString();
//		createdAt = in.readString();
//		idTrip = in.readString();
//		idUsersPemesan = in.readString();
//	}
//
//	public static final Creator<HistoryData> CREATOR = new Creator<HistoryData>() {
//		@Override
//		public HistoryData createFromParcel(Parcel in) {
//			return new HistoryData(in);
//		}
//
//		@Override
//		public HistoryData[] newArray(int size) {
//			return new HistoryData[size];
//		}
//	};
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
//		return tanggalPesan;
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
//	@Override
//	public int describeContents() {
//		return 0;
//	}
//
//	@Override
//	public void writeToParcel(Parcel parcel, int i) {
//		parcel.writeString(idPesanan);
//		parcel.writeString(updatedAt);
//		parcel.writeString(idUsersOperator);
//		parcel.writeString(tanggalPesan);
//		parcel.writeString(createdAt);
//		parcel.writeString(idTrip);
//		parcel.writeString(idUsersPemesan);
//	}
//}