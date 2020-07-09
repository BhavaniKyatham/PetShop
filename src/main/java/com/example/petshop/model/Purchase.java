package com.example.petshop.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
private int purchaseId;
private int userId;
private int petId;
private LocalDate purchaseDate;
public int getPurchaseId() {
	return purchaseId;
}
public void setPurchaseId(int purchaseId) {
	this.purchaseId = purchaseId;
}
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
public LocalDate getPurchaseDate() {
	return purchaseDate;
}
public void setPurchaseDate(LocalDate purchaseDate) {
	this.purchaseDate = purchaseDate;
}

}
