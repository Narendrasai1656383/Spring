package com.spring.validation.repositary;

import org.springframework.stereotype.Repository;

import com.spring.validation.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
