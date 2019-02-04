package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.thermomix.recipes.entity.Recipe;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository
public class RecipeRepositoryImpl implements RecipeRepositoryCustom {


	@Override
	public List<Recipe>buscarPorTag(String tag){

		log.error("Entra con el tag {}",tag);
		log.info("Entramos en consulta findByTags");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();//SpringMongoConfig.class);
		ctx.refresh();
		
		MongoOperations mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");

		Query q = new Query(Criteria.where("tags").all(tag));
		List<Recipe> recipes = mongoOperations.find(q, Recipe.class);
		log.info("Fin en consulta findByTags {} encontradas",recipes.size());
		return recipes;
	}

}
