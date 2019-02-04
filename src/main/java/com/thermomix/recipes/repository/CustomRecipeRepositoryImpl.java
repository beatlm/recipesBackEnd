package com.thermomix.recipes.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.thermomix.recipes.entity.Recipe;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public  class CustomRecipeRepositoryImpl implements CustomRecipeRepository {
	@Value("${spring.data.mongodb.database}")
	private String databaseName;
	@Value("${spring.data.mongodb.uri}")
	private String databaseUri;



	@Override
	public List<Recipe>query(String tag){
		log.info("Lanzamos consulta");
		MongoClient client=new  MongoClient(new MongoClientURI(databaseUri));
		MongoOperations mongoOperations = new MongoTemplate(client, databaseName);
		Query q = new Query(Criteria.where("tags").all(tag));
		
		List<Recipe>result=mongoOperations.find(q, Recipe.class);
		log.info("Fin consulta bd {} resultados",result.size());
		return  result;

	}
}
