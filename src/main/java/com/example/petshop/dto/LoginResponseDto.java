package com.example.petshop.dto;

/**
 * @author Bhavani Kyatham
 *
 */
public class LoginResponseDto {
	private	String message;
	private int statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
