package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.thermomix.recipes.entity.Recipe;

public abstract class RecipeRepositoryImpl implements RecipeRepository {


	@Override
	public List<Recipe>findByTags(String tag){
		ApplicationContext ctx = new AnnotationConfigApplicationContext();//SpringMongoConfig.class);
		MongoOperations mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");

		Query q = new Query(Criteria.where("tags").all(tag));
		List<Recipe> recipes = mongoOperations.find(q, Recipe.class);

		return recipes;
	}
}
