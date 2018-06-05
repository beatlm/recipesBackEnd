package com.thermomix.recipes.recipes;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;

//@ControllerAdvice
public class AddHeader {//implements ResponseBodyAdvice<Collection<?>> {


	//@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		//Checks if this advice is applicable. 
		//In this case it applies to any endpoint 
		return true;
	}
}


