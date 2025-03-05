package com.spring.validation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.validation.dao.UserRequest;
import com.spring.validation.entity.User;
import com.spring.validation.exception.IdNotFoundException;
import com.spring.validation.exception.NotFoundAnyUserException;
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
	public List<User> getAllUsers() throws NotFoundAnyUserException{
		List<User> users=repository.findAll();
		if(users.isEmpty()) {
			throw new NotFoundAnyUserException("No User found");
		}
		return users;
	}
	public Optional<User> getUser(int id) throws IdNotFoundException {
		Optional<User> user=repository.findById(id);
		if(user.isEmpty()) {
			throw new IdNotFoundException("Invalid UserId: "+id);
		}
		return user;
	}
}
