package com.example.petshop.dto;

import javax.validation.constraints.NotEmpty;

public class PurchasePetDto {
	@NotEmpty(message="userId should not be empty")
	private int userId;
	@NotEmpty(message="petId should not be empty")
	private int petId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	
}
