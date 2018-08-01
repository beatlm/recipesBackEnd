package com.thermomix.recipes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thermomix.recipes.model.User;

@RepositoryRestResource(collectionResourceRel = "result", path = "recipes") 

@CrossOrigin(origins = {"https://tm-recipes.firebaseapp.com", "http://localhost:4200"}, 
methods={RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public interface UserRepository extends CrudRepository<User,String> {
	
	@RestResource( rel="buscarPorNombre", path="findByNameNO" )

	  User findByUsername(final String username);
	

}
