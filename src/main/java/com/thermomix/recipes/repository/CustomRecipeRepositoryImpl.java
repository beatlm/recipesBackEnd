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

public  class CustomRecipeRepositoryImpl implements CustomRecipeRepository {
	@Value("${spring.data.mongodb.database}")
	private String databaseName;
	@Value("${spring.data.mongodb.uri}")
	private String databaseUri;



	@Override
	public List<Recipe>buscarPorTag(String tag){
		MongoClient client=new  MongoClient(new MongoClientURI(databaseUri));
		MongoOperations mongoOperations = new MongoTemplate(client, databaseName);
		Query q = new Query(Criteria.where("tags").all(tag));
		return  mongoOperations.find(q, Recipe.class);

	}
}
