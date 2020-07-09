package com.example.petshop.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pet {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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
