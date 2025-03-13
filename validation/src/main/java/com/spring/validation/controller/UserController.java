package com.spring.validation.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.validation.dto.UserRequest;
import com.spring.validation.entity.User;
import com.spring.validation.exception.IdNotFoundException;
import com.spring.validation.exception.NotFoundAnyUserException;
import com.spring.validation.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@Valid @RequestBody UserRequest userRequest) {
		return new ResponseEntity<>(service.saveUser(userRequest),HttpStatus.CREATED);
	}
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers() throws NotFoundAnyUserException{
		return ResponseEntity.ok(service.getAllUsers());
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws IdNotFoundException{
		Optional<User> user=service.getUser(id);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody UserRequest userRequest) throws IdNotFoundException{
		return new ResponseEntity<>(service.updateUser(id,userRequest),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
	}
}
