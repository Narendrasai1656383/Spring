package com.spring.validation.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="USERS_TBL")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private int age;
	private String nationality;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(
				name="street",column=@Column(name="user_street")
				),
		@AttributeOverride(
				name="city",column=@Column(name="user_city")
				),
		@AttributeOverride(
				name="state",column=@Column(name="user_state")
				),
		@AttributeOverride(
				name="pincode",column=@Column(name="user_pincode")
				)
	})
	private Address address;
}
