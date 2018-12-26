package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.thermomix.recipes.entity.Recipe;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public  class CustomRecipeRepositoryImpl implements CustomRecipeRepository {


	@Override
	public List<Recipe>buscarPorTag(String tag){
		log.info("Se busca el tag "+tag);
		ApplicationContext ctx = new AnnotationConfigApplicationContext();//SpringMongoConfig.class);
		MongoOperations mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Query q = new Query(Criteria.where("tags").all(tag));
		List<Recipe> recipes = mongoOperations.find(q, Recipe.class);
		log.info("Se encuentran {} recetas",recipes.size());
		return recipes;
	}
}
