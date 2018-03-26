package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.thermomix.recipes.entity.Recipe;

@RepositoryRestResource(collectionResourceRel = "recipe", path = "recipes") 

public interface RecipeRepository extends PagingAndSortingRepository<Recipe,String> {
	List<Recipe> findByName(@Param("name") String name); 

	
	
}
