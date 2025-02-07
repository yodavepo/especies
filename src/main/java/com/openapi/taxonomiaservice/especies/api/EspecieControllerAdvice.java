package com.openapi.taxonomiaservice.especies.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.openapi.taxonomiaservice.especies.domain.EspecieAlreadyExistsException;


@RestControllerAdvice
public class EspecieControllerAdvice {

	@ExceptionHandler(EspecieAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	private String especieAlreadyExistsHandler(
			EspecieAlreadyExistsException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	private String validatorHandler(
			MethodArgumentNotValidException exception) {
		return "Existen errores de validacion en el payload";
	}
	
}
