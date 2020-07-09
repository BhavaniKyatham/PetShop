package com.example.petshop.service.impl;


import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.petshop.dao.PetDao;
import com.example.petshop.dao.PurchaseDao;
import com.example.petshop.dao.UserDao;
import com.example.petshop.dto.PurchaseListDto;
import com.example.petshop.dto.PurchaseResponseDto;
import com.example.petshop.model.Pet;
import com.example.petshop.model.Purchase;
import com.example.petshop.service.PurchaseService;
@Service
public class PurchaseServiceImpl implements PurchaseService{
	Log logger = LogFactory.getLog(PurchaseServiceImpl.class);
	
	@Autowired
	PurchaseDao purchaseDao;

    @Autowired
    PetDao petDao;
	
	@Autowired
	UserDao userDao;
	@Override
	public PurchaseResponseDto getListOfPetsByuserId(int userId) {
		PurchaseResponseDto purchaseResponseDto = new PurchaseResponseDto();
		Optional<List<Purchase>> purchaseOptional = purchaseDao.findAllByUserId(userId);
		if(!purchaseOptional.isPresent())
		{
			purchaseResponseDto.setMessage("Please verify userId");
			purchaseResponseDto.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
			return purchaseResponseDto;
		}
		else
		
			return purchaseResponseDto;
		}
		

	    
	    private PurchaseListDto getPurchaseListDto(Purchase purchase)
	    {
	    	PurchaseListDto purchaseListDto = new PurchaseListDto();
	        
	        Optional<Pet> pets = petDao.findById(purchase.getPetId());
	        if(!pets.isPresent())
	        	return null;
	        purchaseListDto.setPrice(pets.get().getPrice());
	        purchaseListDto.setPetName(pets.get().getPetName());
	        BeanUtils.copyProperties(purchase, purchaseListDto);
	        return purchaseListDto;
	    }

	    
//		@Override
//		public PurchaseResponseDto purchasepets(List<PurchaseRequestDto> purchaseRequestDtoList, int userId) {
//			 logger.info("Inside getPetslistByUserId method of PurchaseServiceImpl");
//		        List<PurchaseListDto> purchaseListDto = new ArrayList<>();
//		        Optional<List<Purchase>> purchaseList = purchaseDao.findAllByUserId(userId);
//		        if(purchaseList.isPresent())
//		        {
//		            List<Purchase> pet = petList.get();
//		            return pet.stream().map(purchase->getpurchaseListDto(purchase)).collect(Collectors.toList());
//		        }
//		        else {
//		            
//		            return purchaseListDto;
//		        }
//		    }
}
