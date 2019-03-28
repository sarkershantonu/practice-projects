package org.example.ws;

import java.io.IOException;

import org.example.ws.web.api.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
public abstract class AbstractControllerTest extends AbstractTest{
	protected MockMvc mvc; 
	@Autowired
	protected WebApplicationContext webApplicationcontext;
	
	protected void setup()
	{
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationcontext).build(); 
	}
	protected void setup(BaseController controller){
		
		mvc = MockMvcBuilders.standaloneSetup(controller).build(); 
	}
	
	protected String mapToJson(Object obj) throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper(); 
		return mapper.writeValueAsString(obj);
	}
	
	protected <T> T mapFromJson(String json, Class<T> classToCreate) throws JsonParseException, JsonMappingException, IOException
	{		
		ObjectMapper mapper = new ObjectMapper(); 
		return mapper.readValue(json, classToCreate); 
	}
}
