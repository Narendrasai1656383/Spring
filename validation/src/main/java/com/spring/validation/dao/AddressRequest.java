package com.spring.validation.dao;

import lombok.Data;

@Data
public class AddressRequest {
	private String street;
	private String city;
	private String state;
	private String pincode;
}
