package com.almightyjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.almightyjava.utils.MethodUtils;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = DataException.class)
	public ResponseEntity<String> bookNotFoundException(DataException exception) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(MethodUtils.prepareErrorJSON(status, exception), status);
	}
}
