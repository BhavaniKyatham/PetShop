package com.example.petshop.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.dto.PurchaseResponseDto;
import com.example.petshop.service.PurchaseService;


@RestController
public class PurchaseController {
	private static Log logger = LogFactory.getLog(PurchaseController.class);
	@Autowired
	PurchaseService purchaseService;
	
    /**This method return all the list of purchased pets by user
     * @param userId
     * @return list of purchased pets by user
     */
    @GetMapping("/users/{userId}/purchases")
    public ResponseEntity<PurchaseResponseDto> getListOfPetsByuserId(@PathVariable("userId") int userId) 
    {
        logger.info("Inside getListOfPetsByuserId");
        
        return new ResponseEntity<PurchaseResponseDto>(purchaseService.getListOfPetsByuserId(userId),HttpStatus.OK);
    }
}


