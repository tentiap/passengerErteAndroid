package com.example.pemesanerte.model.pemesan;

import com.google.gson.annotations.SerializedName;

public class PemesanOld {

	@SerializedName("data")
	private PemesanDataOld pemesanDataOld;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setPemesanDataOld(PemesanDataOld pemesanDataOld){
		this.pemesanDataOld = pemesanDataOld;
	}

	public PemesanDataOld getPemesanDataOld(){
		return pemesanDataOld;
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