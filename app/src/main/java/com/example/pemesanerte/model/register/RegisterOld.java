package com.example.pemesanerte.model.register;

import com.google.gson.annotations.SerializedName;

public class RegisterOld {

	@SerializedName("data")
	private RegisterDataOld registerDataOld;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setRegisterDataOld(RegisterDataOld registerDataOld){
		this.registerDataOld = registerDataOld;
	}

	public RegisterDataOld getRegisterDataOld(){
		return registerDataOld;
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