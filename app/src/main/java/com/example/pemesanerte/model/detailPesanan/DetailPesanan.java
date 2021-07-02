package com.example.pemesanerte.model.detailPesanan;

import com.google.gson.annotations.SerializedName;

public class DetailPesanan{

	@SerializedName("data")
	private DetailPesananData detailPesananData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDetailPesananData(DetailPesananData detailPesananData){
		this.detailPesananData = detailPesananData;
	}

	public DetailPesananData getDetailPesananData(){
		return detailPesananData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}