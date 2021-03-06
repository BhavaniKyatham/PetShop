package com.example.petshop.service.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petshop.dao.UserDao;
import com.example.petshop.dto.LoginDto;
import com.example.petshop.dto.LoginResponseDto;
import com.example.petshop.model.User;
import com.example.petshop.service.UserService;

/**
 * @author Bhavani Kyatham
 *
 */
@Service
public class UserServiceImpl implements UserService{

	 private static Log logger = LogFactory.getLog(UserServiceImpl.class);
	 @Autowired
	    UserDao userDao;
	@Override
	public LoginResponseDto loginUser(@Valid LoginDto loginDto) {
		logger.info("Inside loginUser method of UserServiceImpl");
        LoginResponseDto loginResponseDto = new LoginResponseDto();
           Optional<User> user = userDao.findByUserNameAndPassword(loginDto.getUserName(),loginDto.getPassword());
           if (user.isPresent()) {
               logger.info("user logged in successfully");
               loginResponseDto.setMessage("User logged in Successfully");
               loginResponseDto.setStatusCode(HttpStatus.OK.value());
               
               return loginResponseDto;
           }  
           loginResponseDto.setMessage("Invalid credentials!!!");
           loginResponseDto.setStatusCode(HttpStatus.UNAUTHORIZED.value());
           return loginResponseDto;

       }
}

