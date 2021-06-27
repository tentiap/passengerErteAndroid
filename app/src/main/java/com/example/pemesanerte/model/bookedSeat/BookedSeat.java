package com.example.pemesanerte.model.bookedSeat;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BookedSeat {

	@SerializedName("data")
	private List<BookedSeatData> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(List<BookedSeatData> data){
		this.data = data;
	}

	public List<BookedSeatData> getData(){
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