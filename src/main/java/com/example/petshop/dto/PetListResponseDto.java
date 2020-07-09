package com.example.petshop.dto;

import java.util.List;

public class PetListResponseDto {
	List<PetResponseDto> PetResponseDtoList;
	private String message;
	private int statusCode;
	public List<PetResponseDto> getPetResponseDtoList() {
		return PetResponseDtoList;
	}
	public void setPetResponseDtoList(List<PetResponseDto> petResponseDtoList) {
		PetResponseDtoList = petResponseDtoList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
