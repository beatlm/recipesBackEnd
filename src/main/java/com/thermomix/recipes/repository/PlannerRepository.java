package com.thermomix.recipes.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(collectionResourceRel = "result", path = "planner") 

//@CrossOrigin(origins = {"http://localhost:4200", "https://tm-recipes-front.herokuapp.com"}, 
//methods={RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public interface PlannerRepository extends PagingAndSortingRepository<com.thermomix.recipes.entity.Planner,String> {
	
	@RestResource( rel="buscarPorUsuario", path="findByUserId" )
	 List<com.thermomix.recipes.entity.Planner> findByUserId(@Param("userId") String userId); 
	
	@RestResource( rel="buscarPorFecha", path="findByDate" )
	List<com.thermomix.recipes.entity.Planner> findByDate(@Param("date") Date date); 

	
	
}
