package com.thermomix.recipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thermomix.recipes.entity.Recipe;
import com.thermomix.recipes.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class RecipesController {
	@Autowired
	private  RecipeRepository repository;

    
    

    @RequestMapping(value = "/myRecipes", method = RequestMethod.GET)
    public ResponseEntity<List <Recipe>> findByTag(@Param (value="tag") String tag) {
    	log.info("Entra en controlador");
        return new ResponseEntity<> ( repository.query(tag), HttpStatus.OK);
    }

}
