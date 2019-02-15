package com.thermomix.recipes.config;

public class ConfigConstant {
	public static String LOGIN_URL = "/login";
	
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "https://www.tm-recipes.com/";
	public static final String SUPER_SECRET_KEY = "1234";
	public static final long TOKEN_EXPIRATION_TIME = 300000; // 5min

	public static final String REGISTER_URL = "/register";

}
