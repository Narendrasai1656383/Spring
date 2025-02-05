package com.firstSpring.first_spring_framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormController {
	@Autowired
	NormService service;
   @RequestMapping("/")
   public String method() {
	   return "My first one";
   }
  @RequestMapping("/hello")
  public String hello(){
	   return "Hello";
  }
  @GetMapping("/getProduct/{id}")
  public Product getProductById(@PathVariable int id) {
	  return  service.getById(id);
  }
  @PostMapping("/product")
  public void addProduct(@RequestBody Product product) {
	  service.push(product);
  }
}
