package com.thermomix.recipes.model;

import java.util.List;

import lombok.Data;
@Data
public class Recipe {
	private String name;
	private int comensales;
	private int totalTime;
	private int preparingTime;
	private List<Object> ingredients;
	private String imagen;
	
}
