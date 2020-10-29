package com.example.pemesanerte.model.history;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class History{

	@SerializedName("data")
	private List<History> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(List<History> data){
		this.data = data;
	}

	public List<History> getData(){
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