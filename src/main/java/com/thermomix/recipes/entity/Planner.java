package com.thermomix.recipes.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;
@Data
public class Planner {
	@Id
	private String id;
	private String recipeId;
	private String userId;
	private Date date;

}
