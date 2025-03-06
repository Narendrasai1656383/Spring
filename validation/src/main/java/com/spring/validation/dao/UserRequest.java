package com.spring.validation.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {
	@NotNull(message="username shouldn't be bull")
	private String name;
	@Email(message="Invalid email address")
	private String email;
	@NotNull(message="Invalid mobile number")
	@jakarta.validation.constraints.Pattern(regexp="^\\d{10}$",message="Invalid Mobile number")
	private String mobile;
	private String gender;
	@Min(value=18,message = "Age must be at least 18")
	@Max(value = 100, message = "Age must be at most 100")
	private int age;
	@NotBlank
	private String nationality;
}
