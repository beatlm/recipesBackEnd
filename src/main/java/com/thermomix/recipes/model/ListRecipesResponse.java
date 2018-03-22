package com.thermomix.recipes.model;

import java.util.List;

public class ListRecipesResponse {
	private List<Recipe> recipes;

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}
