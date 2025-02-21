package com.firstSpring.first_spring_framework.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpring.first_spring_framework.model.Product;
import com.firstSpring.first_spring_framework.service.NormService;

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
  @GetMapping("/GetProducts")
  public List<Product> GetProducts() {
	  return service.getProducts();
  }
  @GetMapping("/getProduct/{id}")
  public Optional<Product> getProductById(@PathVariable int id) {
	  return  service.getById(id);
  }
  @PostMapping("/product")
  public void addProduct(@RequestBody Product product) {
	  service.push(product);
  }
  @PutMapping("/product")
  public void editProduct(@RequestBody Product product) {
	  service.edit(product);
  }
  @DeleteMapping("/product/{id}")
  public void delete(@PathVariable int id) {
	  service.delete(id);
  }
}
