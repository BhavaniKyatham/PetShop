package com.example.petshop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.petshop.dao.PetDao;
import com.example.petshop.dao.UserDao;
import com.example.petshop.dto.PetResponseDto;
import com.example.petshop.dto.PurchasePetDto;
import com.example.petshop.dto.PurchasePetResponseDto;
import com.example.petshop.exceptions.PetNotFoundException;
import com.example.petshop.model.Pet;
import com.example.petshop.service.PetService;


/**
 * @author Bhavani Kyatham
 *
 */
@Service
public class PetServiceImpl implements PetService{

	 private static Log logger = LogFactory.getLog(PetServiceImpl.class);
	 @Autowired
	    PetDao petDao;
	 @Autowired
	    UserDao userDao;
	@Override
	public List<PetResponseDto> getPetsByPetName(String petName) throws PetNotFoundException {
		logger.info("executing the gepetsBypetName and return the list of pets");
		Optional<List<Pet>> petsOptional=petDao.getPetsByPetName(petName);
		if(petsOptional.isPresent()) {
		return petsOptional.get().stream().map(pet->getPetResponseDto(pet)).collect(Collectors.toList());
	}
		throw new PetNotFoundException("There exists no pets with the given petName:"+petName);

	}

	/**
	 * @param pet
	 * @return responsedto
	 */
	private PetResponseDto getPetResponseDto(Pet pet) {
		PetResponseDto responseDto= new PetResponseDto();
		BeanUtils.copyProperties(pet, responseDto);
		return responseDto;
	}

	
	
	
	
	
	
	
	
	
	@Override
	public PurchasePetResponseDto purchaseDetails(PurchasePetDto purchasePetDto) {
		logger.info("Inside purchaseDetails method of PetServiceImpl");
		PurchasePetResponseDto purchasePetResponseDto = new PurchasePetResponseDto();
           Optional<Pet> pet = petDao.findByUserIdAndPetId(purchasePetDto.getUserId(),purchasePetDto.getPetId());
           if (pet.isPresent()) {
               logger.info("user Purchased pet successfully");
               purchasePetResponseDto.setMessage("User purchased Successfully");
               purchasePetResponseDto.setStatusCode(HttpStatus.OK.value());
               
               return purchasePetResponseDto;
           }  
           purchasePetResponseDto.setMessage("Invalid credentials!!!");
           purchasePetResponseDto.setStatusCode(HttpStatus.UNAUTHORIZED.value());
           return purchasePetResponseDto;

       
	}
	
}