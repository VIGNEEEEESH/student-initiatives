package com.woxsen.studentinitiatives.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.woxsen.studentinitiatives.entities.misc.ErrorMessage;
import com.woxsen.studentinitiatives.exceptions.InvalidTypeException;
import com.woxsen.studentinitiatives.exceptions.NoSuchFileFoundException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RESTGlobalExceptionHandler {
	
	@ExceptionHandler(value = EntityNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage entityNotFoundExceptionHandler(EntityNotFoundException e, WebRequest request) {
		ErrorMessage erMsg = new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
		return erMsg;
	}
	
	@ExceptionHandler(value = InvalidTypeException.class)
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	public ErrorMessage invalidTypeExceptionHandler(InvalidTypeException e, WebRequest request) {
		ErrorMessage erMsg = new ErrorMessage(HttpStatus.METHOD_NOT_ALLOWED,e.getMessage());
		return erMsg;
	}
	
	@ExceptionHandler(value = NoSuchFileFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage noSuchFileFoundExceptionHandler(NoSuchFileFoundException e, WebRequest request) {
		ErrorMessage erMsg = new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
		return erMsg;
	}
}
