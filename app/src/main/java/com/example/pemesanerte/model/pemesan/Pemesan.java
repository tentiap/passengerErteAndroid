package com.example.pemesanerte.model.pemesan;

import com.google.gson.annotations.SerializedName;

public class Pemesan{

	@SerializedName("data")
	private PemesanData pemesanData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setPemesanData(PemesanData pemesanData){
		this.pemesanData = pemesanData;
	}

	public PemesanData getPemesanData(){
		return pemesanData;
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