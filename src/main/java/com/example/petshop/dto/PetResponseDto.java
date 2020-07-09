package com.example.petshop.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.petshop.model.availabilityStatus;

public class PetResponseDto {
private int petId;
private String petName;
@Enumerated(value=EnumType.STRING)
private availabilityStatus availabilityStatus;
private int price;
public int getPetId() {
	return petId;
}
public void setPetId(int petId) {
	this.petId = petId;
}
public String getPetName() {
	return petName;
}
public void setPetName(String petName) {
	this.petName = petName;
}
public availabilityStatus getAvailabilityStatus() {
	return availabilityStatus;
}
public void setAvailabilityStatus(availabilityStatus availabilityStatus) {
	this.availabilityStatus = availabilityStatus;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
