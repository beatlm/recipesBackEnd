package com.thermomix.recipes.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thermomix.users.UserRepository;
import com.thermomix.users.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController

public class AuthenticationController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encryptor;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity authenticate(@RequestBody @Valid AuthenticateUser user) {
		log.info("Autenticamos usuario:{} con pasword {} ", user.getUsername(), user.getPassword());
		User foundUser = userRepository.findByUsername(user.getUsername());

		if (foundUser!=null){
			log.info("Found: " + foundUser.getUsername());
			if(encryptor.matches(foundUser.getPassword(),user.getPassword())){
				//				TokenData tokenData = new TokenData();
				//				tokenData.setId(foundUser.getId());
				//				tokenData.setName(foundUser.getUsername());
				//				tokenData.setToken("Token");
				return new ResponseEntity<>( HttpStatus.OK);
			}else {
				log.info("Password password bd:  '{}' recibida;  '{}'",user.getPassword() );
			}
		} 
		log.info("No se ha encontrado al usuario");
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody @Valid AuthenticateUser user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(encryptor.encode(user.getPassword()));

		User foundUser = userRepository.findByUsername(newUser.getUsername());
	
		if(foundUser!=null){
			log.info("YA existe ese usuario en bbdd");

			return new ResponseEntity<>(foundUser.getUsername(), HttpStatus.BAD_REQUEST);
		}
		log.info("Guardamos el usuario '{}' con password '{}'", newUser.getUsername(), newUser.getPassword());
		userRepository.save(newUser);



		return new ResponseEntity<>(newUser.getUsername(), HttpStatus.OK);

	}

}
