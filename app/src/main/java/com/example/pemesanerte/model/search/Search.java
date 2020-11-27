package com.example.pemesanerte.model.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Search{

	@SerializedName("data")
	private List<SearchData> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(List<SearchData> data){
		this.data = data;
	}

	public List<SearchData> getData(){
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