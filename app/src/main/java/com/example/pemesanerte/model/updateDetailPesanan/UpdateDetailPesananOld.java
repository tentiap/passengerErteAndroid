package com.example.pemesanerte.model.updateDetailPesanan;

import com.google.gson.annotations.SerializedName;

public class UpdateDetailPesananOld {

	@SerializedName("data")
	private DataOld dataOld;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDataOld(DataOld dataOld){
		this.dataOld = dataOld;
	}

	public DataOld getDataOld(){
		return dataOld;
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