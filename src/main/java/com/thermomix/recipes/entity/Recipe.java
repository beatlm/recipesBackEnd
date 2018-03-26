package com.thermomix.recipes.entity;
import javax.persistence.Entity;
@Entity
public class Recipe {
	private String name;
	private int amount;
	private String[] ingredients;
	private int total;
	private int preparation;
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
	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
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
