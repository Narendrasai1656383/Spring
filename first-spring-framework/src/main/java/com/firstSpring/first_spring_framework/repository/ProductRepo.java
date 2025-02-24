package com.firstSpring.first_spring_framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstSpring.first_spring_framework.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

	List<Product> findAll();

}
