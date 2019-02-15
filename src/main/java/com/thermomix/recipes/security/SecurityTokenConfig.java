package com.thermomix.recipes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.thermomix.recipes.config.ConfigConstant;
@Configuration
@EnableWebSecurity
@EnableMongoRepositories(basePackageClasses = { com.thermomix.users.UserRepository.class, com.thermomix.recipes.repository.RecipeRepository.class })

public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
	private UserDetailsService userDetailsService;

	public SecurityTokenConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies
		 * 2. Se activa la configuración CORS con los valores por defecto
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticación
		 * 5. Se indica que el resto de URLs esten securizadas
		 */
		httpSecurity
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.cors().and()
		.csrf().disable()
		.authorizeRequests().antMatchers(HttpMethod.POST, ConfigConstant.LOGIN_URL).permitAll()
		.antMatchers(HttpMethod.POST, ConfigConstant.REGISTER_URL).permitAll()
		.anyRequest().authenticated().and()
		.addFilter(new JwtAuthenticationFilter(authenticationManager()))
		.addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config=new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedOrigin("https://tm-recipes-front.herokuapp.com");
		config.addAllowedOrigin("http://localhost:8080");
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");		    
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}
