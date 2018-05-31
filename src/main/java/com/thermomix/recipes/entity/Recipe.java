package com.thermomix.recipes.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.thermomix.recipes.anotation.CascadeSave;

public class Recipe {
	@Id
	private String id;

	private String name;
	private int amount;
	@DBRef
	@CascadeSave
	private List<Ingredient> ingredients;
	private int total;
	private int preparation;
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPreparation() {
		return preparation;
	}
	public void setPreparation(int preparation) {
		this.preparation = preparation;
	}

}
