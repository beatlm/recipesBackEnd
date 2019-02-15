package com.thermomix.users.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {
	@Id

	private String id;

	private String username;

	private String password;

	

}
