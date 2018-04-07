package com.thermomix.recipes.entity;

import org.springframework.data.annotation.Id;

public class Ingredient {
	@Id
	private String id;
	private String name;
	private String amount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	
}
