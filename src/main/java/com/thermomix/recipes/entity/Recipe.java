package com.thermomix.recipes.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


public class Recipe {
	@Id
	private String id;

	private String name;
	private int amount;
	private List<Ingredient> ingredients;
	private int total;
	private int preparation;
	private List<String> pasos;
	private String imagen;
	@Field
	private List <String> tags;

	
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public List<String> getPasos() {
		return pasos;
	}
	public void setPasos(List<String> pasos) {
		this.pasos = pasos;
	}
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
