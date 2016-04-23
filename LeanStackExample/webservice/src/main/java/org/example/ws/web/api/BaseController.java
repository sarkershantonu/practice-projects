package org.example.ws.web.api;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.example.ws.web.DefaultExceptionAttributes;
import org.example.ws.web.ExceptionAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import antlr.collections.List;

public class BaseController {
	
	
	protected Logger logger =LoggerFactory.getLogger(this.getClass()); 
	private Set mn = new HashSet<>(); 
	private List m = (List) new ArrayList(); 
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handlException(Exception exception, HttpServletRequest request){
		logger.error("Handling exception ------ ");
		logger.error("Exception", exception);
		
		ExceptionAttributes aExceptionAttributes = new DefaultExceptionAttributes(); 
		Map<String, Object> responses=aExceptionAttributes.getExceptionAttributes(exception, request, HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		logger.error("Done handling exception");
		return new ResponseEntity<Map<String,Object>> (responses, HttpStatus.INTERNAL_SERVER_ERROR); 
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleNoResultFoundException(NoResultException exception, HttpServletRequest request){
		logger.info("Handling exception-> No result found");
		ExceptionAttributes aExceptionAttributes = new DefaultExceptionAttributes(); 
		Map<String, Object> responses=aExceptionAttributes.getExceptionAttributes(exception, request, HttpStatus.NOT_FOUND);
		
		logger.error("Done handling exception");
		return new ResponseEntity<Map<String,Object>> (responses, HttpStatus.NOT_FOUND); 
	}
}
