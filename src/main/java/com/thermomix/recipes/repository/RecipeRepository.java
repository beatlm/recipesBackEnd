package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thermomix.recipes.entity.Recipe;

@RepositoryRestResource(collectionResourceRel = "result", path = "recipes") 

@CrossOrigin(origins = "http://localhost:4200, http://tm-recipes.firebaseapp.com", methods={RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public interface RecipeRepository extends PagingAndSortingRepository<Recipe,String> {
	
	@RestResource( rel="buscarPorNombre", path="findByName" )
	List<Recipe> findByName(@Param("name") String name); 

	
	
}
