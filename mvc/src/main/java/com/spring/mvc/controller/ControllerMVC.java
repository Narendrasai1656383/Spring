package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerMVC {
	@GetMapping("/")
	public String getHome() {
		return "home.jsp";
	}
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String email,Model model) {
		model.addAttribute("firstname",firstname);
		model.addAttribute("lastname",lastname);
		model.addAttribute("email",email);
		return "success.jsp";
	}
}
