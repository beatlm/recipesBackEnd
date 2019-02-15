package com.thermomix.recipes.controller;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AuthenticateUser {
	@NotNull
	private String username;
	@NotNull
	private String password;

}
