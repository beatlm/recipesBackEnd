package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.thermomix.recipes.entity.Recipe;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public  class CustomRecipeRepositoryImpl implements CustomRecipeRepository {
@Value("${spring.data.mongodb.database}")
private String databaseName;
@Value("${spring.data.mongodb.uri}")
private String databaseUri;
	@Override
	public List<Recipe>buscarPorTag(String tag){
		log.info("Se busca el tag "+tag);
		//AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext();//SpringMongoConfig.class);
		log.info("1 ");
		//ctx.refresh();
		log.info("1.5 "+databaseName+" - "+databaseUri);
		MongoClient client=new MongoClient(databaseUri);
		MongoOperations mongoOperations = new MongoTemplate(client, databaseName);;//(MongoOperations) ctx.getBean("mongoTemplate");
		log.info("2");
		Query q = new Query(Criteria.where("tags").all(tag));
		log.info("3");
		List<Recipe> recipes = mongoOperations.find(q, Recipe.class);
	 
		log.info("Se encuentran {} recetas",recipes.size());
		return recipes;
	}
}
