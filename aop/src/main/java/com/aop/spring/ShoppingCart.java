package com.aop.spring;

import org.springframework.stereotype.Service;

@Service
public class ShoppingCart {
	public void checkout() {
		//Logging
		//Authentication & Authorization
		//Sanitize the Data
		System.out.println("Checkout method fro shoppingcart called");
	}
}
