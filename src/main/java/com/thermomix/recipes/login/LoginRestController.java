package com.thermomix.recipes.login;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

@CrossOrigin(origins = {"https://tm-recipes.firebaseapp.com", "http://localhost:4200"}, 
methods={RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class LoginRestController {




	@Autowired
	FacebookService facebookService;
	@GetMapping(path= "/createFacebookAuthorization", produces = "text/plain") 
	public String createFacebookAuthorization(){
		return facebookService.createFacebookAuthorizationURL();
	}
	
	@GetMapping("/facebook")
	public void createFacebookAccessToken(@RequestParam("code") String code){

			facebookService.createFacebookAccessToken(code);
		
	}
	
	@GetMapping("/getName")
	public String getNameResponse(){
	    return facebookService.getName();
	}

}
