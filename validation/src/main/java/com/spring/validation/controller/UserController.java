package com.spring.validation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.validation.dao.UserRequest;
import com.spring.validation.entity.User;
import com.spring.validation.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<>(service.saveUser(userRequest),HttpStatus.CREATED);
	}
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(service.getAllUsers());
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		Optional<User> user=service.getUser(id);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
