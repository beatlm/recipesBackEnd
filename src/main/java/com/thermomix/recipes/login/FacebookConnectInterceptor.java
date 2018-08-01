package com.thermomix.recipes.login;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacebookConnectInterceptor implements ConnectInterceptor<Facebook> {

	public void preConnect(ConnectionFactory<Facebook> provider, MultiValueMap<String, String> parameters, WebRequest request) {
		log.info("Pre connect FacebookInterceptor");	
	}

	public void postConnect(Connection<Facebook> connection, WebRequest request) {
		log.info("Post connect FacebookInterceptor");	

		connection.updateStatus("I've connected with the Spring Social Showcase!");

	}
}
