package com.thermomix.recipes.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * Spring MongoDB configuration file
 * 
 */
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration{
	
	@Value("${spring.data.mongodb.uri}")
	private String mongoURI; 

	
	@Value("${spring.data.mongodb.database}")
	private String mongoDatabase;
	
	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
	    return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}
	
	@Override
	protected String getDatabaseName() {
		return mongoDatabase;
	}
 

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		//MongoClientURI uri = new MongoClientURI(mongoURI);

	//	return new MongoClient(uri);
		return mongoClient();
	}
	@Bean
	  public MongoClient mongoClient() {    
	    List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
	    credentialsList.add(MongoCredential.createCredential("knhtnafcqszcva", getDatabaseName(), "7056b1f1e7b99313af6383983e033b853418fe63bd1286f20b066f2f252eab77".toCharArray()));
	    ServerAddress primary = new ServerAddress("ec2-54-243-130-33.compute-1.amazonaws.com", 5432);
	    MongoClientOptions mongoClientOptions = MongoClientOptions.builder().connectionsPerHost(4).socketKeepAlive(true).build();
	    return new MongoClient( primary, credentialsList, mongoClientOptions); 
	  }

}