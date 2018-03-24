package com.thermomix.recipes.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thermomix.recipes.model.ListRecipesResponse;
import com.thermomix.recipes.model.Recipe;

@RestController
public class RecipesRestController {

	/**
	 * Method that returns a file as FileReseource from path
	 * @return
	 */
	@RequestMapping(value = "/file", method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource getFile() {

		File file= new File("");
		return new FileSystemResource(file); 
	}

	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public ResponseEntity<List<Recipe>> listAllRecipes(HttpServletResponse response){
		List<Recipe> recipes= new ArrayList<>();
		Recipe r1= new Recipe();
		r1.setName("Salmorejo");
		r1.setComensales(2);
		String a[] = new String[]{"tomates","Pan blanco del dia anterior","Ajo","Aceite", "Vinagre"};

		r1.setIngredients(Arrays.asList(a));
		r1.setPreparingTime(23);
		r1.setTotalTime(40);
		recipes.add(r1);
	

		
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		return  new ResponseEntity<>(recipes,HttpStatus.OK);
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<Integer> test(HttpServletResponse response){
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		return  new ResponseEntity<>(23,HttpStatus.OK);
	}

}
