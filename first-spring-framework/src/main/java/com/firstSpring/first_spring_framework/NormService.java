package com.firstSpring.first_spring_framework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NormService {
	List<Product> l=new ArrayList<>();
	public void push(Product product) {
		l.add(product);
	}
	public Product getById(int cid) {
		return l.stream().filter(li -> li.getId()==cid).findFirst().get();
	}
}