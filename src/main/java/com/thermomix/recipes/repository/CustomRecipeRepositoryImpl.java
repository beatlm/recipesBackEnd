package com.thermomix.recipes.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.thermomix.recipes.entity.Recipe;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public  class CustomRecipeRepositoryImpl implements CustomRecipeRepository {
	@Value("${spring.data.mongodb.database}")
	private String databaseName;
	@Value("${spring.data.mongodb.uri}")
	private String databaseUri;
	@Value("${spring.data.mongodb.port}")
	private Integer mongoPort;
	@Value("${spring.data.mongodb.host}")
	private String mongoHost;
	/*@Value("${spring.data.mongodb.user}")
	private String mongoUser;
	@Value("${spring.data.mongodb.pass}")
	private String mongoPass;*/

	@Override
	public List<Recipe>buscarPorTag(String tag){

		//MongoCredential credential = MongoCredential.createCredential(mongoUser, databaseName, mongoPass.toCharArray());
		ServerAddress serverAddress = new ServerAddress(mongoHost, mongoPort);

		log.info("Se busca el tag "+tag);

		log.info("1 ");
		//ctx.refresh(); 
		log.info("1.5 "+databaseName+" - "+mongoHost+"  -  "+mongoPort);
		MongoClientURI uri= new MongoClientURI(databaseUri);
		MongoClient client=new  MongoClient(uri);// MongoClient(serverAddress, Arrays.asList(credential));
		MongoOperations mongoOperations = new MongoTemplate(client, databaseName);;
		log.info("2");
		Query q = new Query(Criteria.where("tags").all(tag));
		log.info("3");
		List<Recipe> recipes = mongoOperations.find(q, Recipe.class);

		log.info("Se encuentran {} recetas",recipes.size());
		return recipes;
	}
}
