package com.aop.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private ShoppingCart shoppingCart;
	@GetMapping("/")
	public void getShopping() {
		shoppingCart.checkout();
	}
}
