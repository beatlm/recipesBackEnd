package com.thermomix.recipes.login;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class FacebookService {


	@Value("${facebook.appId}")
	private String appId;
	@Value("${facebook.appSecret}")
	private String appSecret;
	
	private String accessToken;
	
	public String createFacebookAuthorizationURL(){
	    FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(appId, appSecret);
	    OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
	    OAuth2Parameters params = new OAuth2Parameters();
	    params.setRedirectUri("http://localhost:8080/facebook");
	    params.setScope("public_profile,email,user_birthday");
	    return oauthOperations.buildAuthorizeUrl(params);
	}
	
	
	
	public void createFacebookAccessToken(String code)  {
	
	    FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(appId, appSecret);
	    AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, "http://localhost:8080/facebook", null);
	    accessToken = accessGrant.getAccessToken();
	}
	
	public String getName() {
	    Facebook facebook = new FacebookTemplate(accessToken);
	    String[] fields = {"id", "name"};
	    return facebook.fetchObject("me", String.class, fields);
	}
}
