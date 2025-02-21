package com.firstSpring.first_spring_framework.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstSpring.first_spring_framework.model.Product;
import com.firstSpring.first_spring_framework.repository.ProductRepo;

@Service
public class NormService {
	@Autowired
	ProductRepo repo;
//	List<Product> l=new ArrayList<>();
	public List<Product> getProducts(){
		return repo.findAll();
	}
	public void push(Product product) {
		repo.save(product);
	}
	public Optional<Product> getById(int cid) {
		return repo.findById(cid);
	}
	public void edit(Product product) {
		repo.save(product);
	}
	public void delete(int cid) {
		repo.deleteById(cid);;
	}
}