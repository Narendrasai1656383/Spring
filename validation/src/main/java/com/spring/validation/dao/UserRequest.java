package com.spring.validation.dao;

import org.hibernate.annotations.processing.Pattern;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@NotNull(message="username shouldn't be bull")
	private String name;
	@Email(message="Invalid email address")
	private String email;
	@NotNull
	@jakarta.validation.constraints.Pattern(regexp="^\\d{10}$",message="Invalid Mobile number")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank
	private String nationality;
}
