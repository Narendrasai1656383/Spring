package com.spring.mvc.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{
	
}
