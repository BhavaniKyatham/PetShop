package com.example.petshop.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.petshop.dto.PetResponseDto;
import com.example.petshop.exceptions.PetNotFoundException;
import com.example.petshop.service.PetService;

/**
 * @author Bhavani Kyatham
 *
 */
@RestController
public class PetController {
	private static Log logger = LogFactory.getLog(PetController.class);
	@Autowired
	PetService petService;
	
	/**
	 * @param petName
	 * @return
	 * @throws PetNotFoundException
	 */
	@GetMapping("/pets/petName")
	public List<PetResponseDto> getPetsByPetName(@RequestParam("petName")String petName) throws PetNotFoundException {
		logger.info("executing the getPetsByPetName in PetController");
		return petService.getPetsByPetName(petName);
	}
	
	/**
	 * @param exception
	 * @return responseEntity
	 */
	@ExceptionHandler(PetNotFoundException.class)
	public ResponseEntity<String> exceptionhandler(PetNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
}
