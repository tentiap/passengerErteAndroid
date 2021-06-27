package com.example.pemesanerte.model.bookedSeat;

import com.google.gson.annotations.SerializedName;

public class BookedSeatData {

	@SerializedName("id_seat")
	private String idSeat;

	public void setIdSeat(String idSeat){
		this.idSeat = idSeat;
	}

	public String getIdSeat(){
//		String[] seat = idSeat.split(" ");
//		String bookedSeat =  seat[1];
//
//		return bookedSeat;
		return idSeat;
	}
}