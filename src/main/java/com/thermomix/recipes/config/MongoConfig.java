package com.thermomix.recipes.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thermomix.recipes.anotation.CascadeSaveMongoEventListener;

@Configuration
//@EnableMongoRepositories(basePackages = "com.thermomix.repository")
public class MongoConfig   {


	@Bean
	public CascadeSaveMongoEventListener cascadingMongoEventListener() {
		return new CascadeSaveMongoEventListener();
	}


}