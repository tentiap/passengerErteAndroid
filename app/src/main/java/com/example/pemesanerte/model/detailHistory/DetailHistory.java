package com.example.pemesanerte.model.detailHistory;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DetailHistory{

	@SerializedName("data")
	private List<DetailHistoryData> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(List<DetailHistoryData> data){
		this.data = data;
	}

	public List<DetailHistoryData> getData(){
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