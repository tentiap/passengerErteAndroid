package com.example.pemesanerte.model.register;

import com.google.gson.annotations.SerializedName;

public class Register{

	@SerializedName("data")
	private RegisterData registerData;

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	public void setRegisterData(RegisterData registerData){
		this.registerData = registerData;
	}

	public RegisterData getRegisterData(){
		return registerData;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}