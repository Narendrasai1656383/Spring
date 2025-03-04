package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.spring.mvc.model.Customer;
import com.spring.mvc.repositary.CustomerRepo;


@Controller
public class ControllerMVC {
	@Autowired
	CustomerRepo repo;
	@GetMapping("/")
	public String getHome() {
		return "home.jsp";
	}
	@PostMapping("/addCustomer")
	public String addCustomer(Customer data,Model model) {
		Customer cust=repo.save(data);
		model.addAttribute("customer",cust);
		return "success.jsp";
	}
}
