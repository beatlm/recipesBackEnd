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
@Value("${spring.data.mongodb.port}")
private Integer databasePort;
@Value("${spring.data.mongodb.host}")
private String databaseHost;
 
	@Override
	public List<Recipe>buscarPorTag(String tag){
		log.info("Se busca el tag "+tag);
	
		log.info("1 ");
		//ctx.refresh();
		log.info("1.5 "+databaseName+" - "+databaseHost+"  -  "+databasePort);
		MongoClient client=new MongoClient(databaseHost,databasePort);
		MongoOperations mongoOperations = new MongoTemplate(client, databaseName);;
		log.info("2");
		Query q = new Query(Criteria.where("tags").all(tag));
		log.info("3");
		List<Recipe> recipes = mongoOperations.find(q, Recipe.class);
	 
		log.info("Se encuentran {} recetas",recipes.size());
		return recipes;
	}
}
