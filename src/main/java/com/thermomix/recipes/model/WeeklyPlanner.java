package com.thermomix.recipes.model;

import java.util.Date;

import lombok.Data;
@Data
public class WeeklyPlanner {
	private String recipeId;
	private String userId;
	private Date date;

}
