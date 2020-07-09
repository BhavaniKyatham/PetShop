package com.example.petshop.service;

import java.util.List;
import com.example.petshop.dto.PetResponseDto;
import com.example.petshop.dto.PurchasePetDto;
import com.example.petshop.dto.PurchasePetResponseDto;
import com.example.petshop.exceptions.PetNotFoundException;

/**
 * @author Bhavani Kyatham
 *
 */
public interface PetService {

	List<PetResponseDto> getPetsByPetName(String petName)throws PetNotFoundException;

	public PurchasePetResponseDto purchaseDetails(PurchasePetDto purchasePetDto);

}
