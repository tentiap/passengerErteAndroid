package com.example.pemesanerte.model.idPesanan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class IdPesanan{

	@SerializedName("data")
	private List<IdPesananData> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(List<IdPesananData> data){
		this.data = data;
	}

	public List<IdPesananData> getData(){
		return data;
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