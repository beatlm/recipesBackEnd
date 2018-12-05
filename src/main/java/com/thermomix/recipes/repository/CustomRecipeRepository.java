package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.data.rest.core.annotation.RestResource;

import com.thermomix.recipes.entity.Recipe;


public interface CustomRecipeRepository {


	@RestResource( rel="buscarPorTag", path="findByTag" )

	public List<Recipe>buscarPorTag(String tag);
}
