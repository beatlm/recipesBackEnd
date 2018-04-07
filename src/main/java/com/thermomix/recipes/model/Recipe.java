package com.thermomix.recipes.model;

import java.util.List;
//TODO añadir lombok
public class Recipe {
	private String name;
	private int comensales;
	private int totalTime;
	private int preparingTime;
/*	private List<Object> ingredients;
	public List<Object> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Object> list) {
		this.ingredients = list;
	}*/
	public int getComensales() {
		return comensales;
	}
	public void setComensales(int comensales) {
		this.comensales = comensales;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public int getPreparingTime() {
		return preparingTime;
	}
	public void setPreparingTime(int preparingTime) {
		this.preparingTime = preparingTime;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
