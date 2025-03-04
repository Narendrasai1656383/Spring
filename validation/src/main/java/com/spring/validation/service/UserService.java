package com.spring.validation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.validation.dao.UserRequest;
import com.spring.validation.entity.User;
import com.spring.validation.repositary.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public User saveUser(UserRequest userRequest) {
		 User user = new User(0,
                 userRequest.getName(),
                 userRequest.getEmail(),
                 userRequest.getMobile(),
                 userRequest.getGender(),
                 userRequest.getAge(),
                 userRequest.getNationality());
		 return repository.save(user);	
	}
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	public Optional<User> getUser(int id) {
		return repository.findById(id);
	}
}
