package com.example.petshop.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.petshop.dto.PurchasePetDto;
import com.example.petshop.dto.PurchasePetResponseDto;
import com.example.petshop.service.PetService;

@RestController
public class PurchasePetController {
	private static Log logger = LogFactory.getLog(PurchasePetController.class);
	@Autowired
	PetService petService;
	
@PostMapping("/purchase")
public ResponseEntity<PurchasePetResponseDto> purchaseDetails( @RequestBody PurchasePetDto purchasePetDto) {
	logger.info("Inside purchase method ");

	return new ResponseEntity<PurchasePetResponseDto>(petService.purchaseDetails(purchasePetDto), HttpStatus.OK);

}
}