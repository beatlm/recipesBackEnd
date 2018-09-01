package com.thermomix.recipes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thermomix.recipes.entity.Recipe;

@RepositoryRestResource(collectionResourceRel = "result", path = "recipes") 

@CrossOrigin(origins = {"http://localhost:4200", "https://tm-recipes-front.herokuapp.com"}, 
methods={RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public abstract class RecipeRepositoryImpl implements RecipeRepositoryCustom {
	
	public List<Recipe> findByTag(@Param("tag") String tag){
		return null;
		
	}

	
	
}
