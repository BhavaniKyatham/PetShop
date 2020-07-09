package com.example.petshop.service;

import com.example.petshop.dto.PurchaseResponseDto;

public interface PurchaseService {

	PurchaseResponseDto getListOfPetsByuserId(int userId);

	//PurchaseResponseDto purchasepets(List<PurchaseRequestDto> purchaseRequestDtoList, int userId);

	

}
