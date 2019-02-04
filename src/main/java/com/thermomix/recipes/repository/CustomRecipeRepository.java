package com.thermomix.recipes.repository;

import java.util.List;

import com.thermomix.recipes.entity.Recipe;


public interface CustomRecipeRepository {

	public List<Recipe>query(String tag);
}
