package com.thermomix.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class RecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesApplication.class, args);
	}
	
	/*@Bean
	  public FilterRegistrationBean<CorsFilter> corsFilter() {
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("http://localhost:4200");
	    config.addAllowedOrigin("https://tm-recipes-front.herokuapp.com");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
	    final FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
	    bean.setOrder(0);
	    return bean;
	  }*/
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}
	
}