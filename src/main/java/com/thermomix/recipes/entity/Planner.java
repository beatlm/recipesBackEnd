package com.thermomix.recipes.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Planner {
	@Id
	private String id;
	private String recipeId;
	private String userId;
	 @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;

}
