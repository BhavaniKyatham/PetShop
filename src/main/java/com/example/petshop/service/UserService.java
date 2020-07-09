package com.example.petshop.service;

import javax.validation.Valid;

import com.example.petshop.dto.LoginDto;
import com.example.petshop.dto.LoginResponseDto;

/**
 * @author Bhavani Kyatham
 *
 */
public interface UserService {

	public LoginResponseDto loginUser(@Valid LoginDto loginDto);

}
