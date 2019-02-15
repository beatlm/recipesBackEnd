package com.thermomix.recipes.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thermomix.recipes.config.ConfigConstant;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JwtAuthenticationFilter extends  UsernamePasswordAuthenticationFilter {
   
		
		private AuthenticationManager authenticationManager;
	
		public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
			this.authenticationManager = authenticationManager;
		}
	
		@Override
		public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
				throws AuthenticationException {
			try {
				com.thermomix.users.entity.User credenciales = new ObjectMapper().readValue(request.getInputStream(), com.thermomix.users.entity.User.class);
	
				return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>()));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	
		@Override
		protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
				Authentication auth) throws IOException, ServletException {
	
			String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ConfigConstant.ISSUER_INFO)
					.setSubject(((User)auth.getPrincipal()).getUsername())
					.setExpiration(new Date(System.currentTimeMillis() + ConfigConstant.TOKEN_EXPIRATION_TIME))
					.signWith(SignatureAlgorithm.HS512, ConfigConstant.SUPER_SECRET_KEY).compact();
			response.addHeader(ConfigConstant.HEADER_AUTHORIZACION_KEY, ConfigConstant.TOKEN_BEARER_PREFIX + " " + token);
		}
	}


