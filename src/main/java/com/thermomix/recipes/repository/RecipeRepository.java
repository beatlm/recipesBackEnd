package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thermomix.recipes.entity.Recipe;

@RepositoryRestResource(collectionResourceRel = "result", path = "recipes") 

@CrossOrigin(origins = {"http://localhost:4200", "https://tm-recipes-front.herokuapp.com"}, 
methods={RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PATCH})
public interface RecipeRepository extends PagingAndSortingRepository<Recipe,String> {
	
	@RestResource( rel="buscarPorNombre", path="findByNameNO" )
	List<Recipe> findByName(@Param("name") String name); 

	@RestResource( rel="buscarPorTag", path="findByTag" )
	//public List<Recipe> findByTag(@Param("tags") String tag);
	//@Query (value="db.recipe.find( { tags: ?0 } )")
	 // @Query("db.recipe.find( { 'tags' : ?0 })")

	public List<Recipe>findByTags(String tag);
}
