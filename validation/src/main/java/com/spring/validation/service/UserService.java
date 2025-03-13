package com.spring.validation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.validation.dto.UserRequest;
import com.spring.validation.entity.Address;
import com.spring.validation.entity.User;
import com.spring.validation.exception.IdNotFoundException;
import com.spring.validation.exception.NotFoundAnyUserException;
import com.spring.validation.repositary.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public User saveUser(UserRequest userRequest) {
		Address address=new Address(userRequest.getAddressRequest().getStreet(),
				userRequest.getAddressRequest().getCity(),
				userRequest.getAddressRequest().getState(),
				userRequest.getAddressRequest().getPincode()
				);
		 User user = new User(0,
                 userRequest.getName(),
                 userRequest.getEmail(),
                 userRequest.getMobile(),
                 userRequest.getGender(),
                 userRequest.getAge(),
                 userRequest.getNationality(),
                 address
                 );
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
	public User updateUser(int id, UserRequest userRequest) throws IdNotFoundException {
		User user=repository.findById(id).orElseThrow(() -> new IdNotFoundException("Invalid User Id: "+id));
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setMobile(userRequest.getMobile());
		user.setGender(userRequest.getGender());
		user.setAge(userRequest.getAge());
		user.setNationality(userRequest.getNationality());
		Address address=new Address(
				userRequest.getAddressRequest().getStreet(),
				userRequest.getAddressRequest().getCity(),
				userRequest.getAddressRequest().getState(),
				userRequest.getAddressRequest().getPincode()
				);		
		user.setAddress(address);
		return repository.save(user);
	}
	public void deleteUser(int id) {
		repository.deleteById(id);
	}
}
