package com.example.pemesanerte.model.updateDetailPesanan;

import com.google.gson.annotations.SerializedName;

public class UpdateDetailPesanan{

	@SerializedName("data")
	private UpdateDetailPesananData updateDetailPesananData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setUpdateDetailPesananData(UpdateDetailPesananData updateDetailPesananData){
		this.updateDetailPesananData = updateDetailPesananData;
	}

	public UpdateDetailPesananData getUpdateDetailPesananData(){
		return updateDetailPesananData;
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