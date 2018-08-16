package com.thermomix.recipes.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thermomix.recipes.model.WeeklyPlanner;

@RepositoryRestResource(collectionResourceRel = "result", path = "timeTable") 

@CrossOrigin(origins = {"http://localhost:4200", "https://tm-recipes-front.herokuapp.com"}, 
methods={RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public interface CalendarRepository extends PagingAndSortingRepository<WeeklyPlanner,String> {
	
	@RestResource( rel="buscarPorUsuario", path="findByUserId" )
	List<WeeklyPlanner> findByUserId(@Param("userId") String userId); 
	
	@RestResource( rel="buscarPorFecha", path="findByDate" )
	List<WeeklyPlanner> findByDate(@Param("date") Date date); 

	
	
}
