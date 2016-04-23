package org.example.ws.web.api;

import java.util.Collection;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.example.ws.AbstractControllerTest;
import org.example.ws.model.Greeting;
import org.example.ws.service.GreetingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@Transactional
public class GreetingControllerTest extends AbstractControllerTest {
	@Autowired
	private GreetingService greetingService; 
	
	@Before
	public void setup(){
		super.setup();
		greetingService.evictCache();
	}

	@Test
	public void testGetAllGreetings() throws Exception{
		String uri = "/api/greetings"; 
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus(); 
		Assert.assertEquals("Http status code 200",200,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()>0);
	}
	@Test
	public void testGetGreeting()throws Exception{
		String uri="/api/greetings/{id}";
		Long id = new Long(1); 
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri,id).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn(); 
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus();
		Assert.assertEquals("Http status code 200",200,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()>0);
	}
	
	
	@Test
	public void testGetGreetingNotFound() throws Exception{
		String uri="/api/greetings/{id}";
		Long id = new Long(Long.MAX_VALUE); 
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri,id).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn(); 
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus();
		Assert.assertEquals("Http status code 404",404,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()==0);
	}
	
	@Test
	public void testCreateGreeting() throws Exception
	{
		String uri="/api/greetings";
		Greeting greeting  = new Greeting(); 
		String greetingText = "Test";
		greeting.setText(greetingText);
		String inputJson = super.mapToJson(greeting);
		
		MvcResult result = mvc.perform(
				MockMvcRequestBuilders.post(uri).
				contentType(MediaType.APPLICATION_JSON_VALUE).
				accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus(); 
		Assert.assertEquals("Http status code 201",201,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()>0);
		
		Greeting createdGreeting = super.mapFromJson(content, Greeting.class); 
		Assert.assertNotNull("Not Null", createdGreeting);
		Assert.assertNotNull("not null of id",createdGreeting.getId());
		Assert.assertEquals("Equalization of text", greetingText, createdGreeting.getText());
		
		//checking it is stored 
		Greeting readGreeting = greetingService.findOne(createdGreeting.getId()); 
		Assert.assertNotNull("Not Null", readGreeting);
		Assert.assertEquals("Equalization of id", createdGreeting.getId(),readGreeting.getId());
		Assert.assertEquals("Equalization of text", createdGreeting.getText(), readGreeting.getText());
		
	}
	
	
	@Test 
	public void testUpdateGreeting() throws Exception {
		String uri = "/api/greetings/{id}"; 
		Long id = new Long(1); 
		Greeting testGreeting = greetingService.findOne(id);
		String updatingText = testGreeting.getText()+"Updated Part"; 
		testGreeting.setText(updatingText);
		String inputJson = super.mapToJson(testGreeting);
		
		MvcResult result = mvc.perform(
				MockMvcRequestBuilders.put(uri, id)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus(); 
		Assert.assertEquals("Http status code 202",202,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()>0);
		
		Greeting updatedGreeting = super.mapFromJson(content, Greeting.class); 
		Assert.assertNotNull("Not Null", updatedGreeting);
		Assert.assertEquals("Equalization of id", testGreeting.getId(),updatedGreeting.getId());
		Assert.assertEquals("Equalization of text", updatingText, updatedGreeting.getText());
	}
/*	
	@Test
	public void testDeleteGreeting() throws Exception{
		
		 String uri = "/api/greetings/{id}";
		Long id = new Long(2);
		
		MvcResult result = mvc.perform(
				MockMvcRequestBuilders.delete(uri,id)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus(); 
		Assert.assertEquals("Http status code 204",204,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()==0);
		Assert.assertNull("Should be null ",greetingServices.findOne(id));		
	}*/
    @Test
    public void testDeleteGreeting() throws Exception {

        String uri = "/api/greetings/{id}";
        Long id = new Long(1);

        MvcResult result = mvc.perform(MockMvcRequestBuilders.delete(uri, id)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 204", 204, status);
        Assert.assertTrue("failure - expected HTTP response body to be empty",
                content.trim().length() == 0);

        Greeting deletedGreeting = greetingService.findOne(id);

        Assert.assertNull("failure - expected greeting to be null",
                deletedGreeting);

    }
}
