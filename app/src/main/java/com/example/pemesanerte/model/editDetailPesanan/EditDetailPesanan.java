package com.example.pemesanerte.model.editDetailPesanan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EditDetailPesanan{

	@SerializedName("data")
	private List<EditDetailPesananData> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(List<EditDetailPesananData> data){
		this.data = data;
	}

	public List<EditDetailPesananData> getData(){
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