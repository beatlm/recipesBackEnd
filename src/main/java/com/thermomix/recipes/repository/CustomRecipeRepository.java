package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.data.rest.core.annotation.RestResource;

import com.thermomix.recipes.entity.Recipe;

//@CrossOrigin(origins = {"http://localhost:4200", "https://tm-recipes-front.herokuapp.com"}, 
//methods={RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PATCH})
public interface CustomRecipeRepository {


	@RestResource( rel="buscarPorTag", path="findByTag" )

	public List<Recipe>buscarPorTag(String tag);
}
