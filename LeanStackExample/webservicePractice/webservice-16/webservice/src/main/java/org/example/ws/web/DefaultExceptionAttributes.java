package org.example.ws.web;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;

public class DefaultExceptionAttributes implements ExceptionAttributes
{

	public static final String TIMESTAMP="timestamp";
	public static final String STATUS="status";
	public static final String ERROR="error";
	public static final String EXCEPTION="exception";
	public static final String MESSAGE="message";
	public static final String PATH="path";
	
	@Override
	public Map<String, Object> getExceptionAttributes(Exception exception, 
			HttpServletRequest httpRequest,
			HttpStatus httpstatus) {
		Map<String, Object> exceptionAttributes = new LinkedHashMap<String, Object>(); 
		exceptionAttributes.put(TIMESTAMP, new Date());
		addHttpStatus(exceptionAttributes, httpstatus); 
		addExceptionDetails(exceptionAttributes, exception); 
		addPath(exceptionAttributes, httpRequest); 
		
		return null;
	}
	
	private void addHttpStatus( Map<String, Object> exceptionAttributes, HttpStatus httpstatus){
		exceptionAttributes.put(STATUS, httpstatus.value());
		exceptionAttributes.put(ERROR,httpstatus.getReasonPhrase());
		
	}
	private void addExceptionDetails(Map<String, Object> exceptionAttributes, Exception ex){
		exceptionAttributes.put(EXCEPTION, ex);
		exceptionAttributes.put(MESSAGE,ex.getMessage());
	}
	private void addPath(Map<String, Object> exceptionAttributes, HttpServletRequest httpRequest){
		exceptionAttributes.put(PATH, httpRequest.getServletPath());
	}
	
}
