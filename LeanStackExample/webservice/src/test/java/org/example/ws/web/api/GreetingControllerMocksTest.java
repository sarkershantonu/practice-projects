package org.example.ws.web.api;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Matchers.any;
import java.util.ArrayList;
import java.util.Collection;
import javax.transaction.Transactional;
import org.example.ws.AbstractControllerTest;
import org.example.ws.model.Greeting;
import org.example.ws.service.EmailService;
import org.example.ws.service.GreetingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javassist.compiler.ast.Variable;

@Transactional
public class GreetingControllerMocksTest extends AbstractControllerTest{
	@Mock
	private EmailService emailService; 
	@Mock
	private GreetingService greetingService;
	
	@InjectMocks
	private GreetingController greetingController; 
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		super.setup(greetingController); 
		
	}
	@Test
	public void testGetAllGreetings() throws Exception{
		Collection<Greeting> greetings = getAllEntityListStabData();
		when(greetingService.findAll()).thenReturn(greetings);
		//Mockito.when(getAllEntityListStabData()).thenReturn(greetings); 
		
		String uri = "/api/greetings"; 		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus(); 
		
		verify(greetingService,times(1)).findAll(); //findall 1 time 
		Assert.assertEquals("Http status code 200",200,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()>0);
		
	}
	
	@Test
	public void testGetGreeting()throws Exception{
		String uri="/api/greetings/{id}";
		Long id = new Long(1); 
		Greeting greeting = getSingleEntitySubData(); 
		when(greetingService.findOne(id)).thenReturn(greeting);
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri,id).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn(); 
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus();
		verify(greetingService,times(1)).findOne(id);
		
		Assert.assertEquals("Http status code 200",200,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()>0);
	}
	
	
	@Test
	public void testGetGreetingNotFound() throws Exception{
		String uri="/api/greetings/{id}";
		Long id = new Long(Long.MAX_VALUE); 
		when(greetingService.findOne(id)).thenReturn(null);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri,id).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn(); 
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus();
		verify(greetingService,times(1)).findOne(id);
		
		Assert.assertEquals("Http status code 404",404,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()==0);
	}
	
	@Test
	public void testCreateGreeting() throws Exception
	{
		String uri="/api/greetings";
		Greeting greeting  = getSingleEntitySubData(); 
		String inputJson = super.mapToJson(greeting);
		when(greetingService.create(any(Greeting.class))).thenReturn(greeting);
		
		MvcResult result = mvc.perform(
				MockMvcRequestBuilders.post(uri).
				contentType(MediaType.APPLICATION_JSON_VALUE).
				accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		String content = result.getResponse().getContentAsString(); 
		int responseCode = result.getResponse().getStatus(); 
		Assert.assertEquals("Http status code 201",201,responseCode);
		Assert.assertTrue("Body has value", content.trim().length()>0);
		
		verify(greetingService,times(1)).create(any(Greeting.class));
		Greeting createdGreeting = super.mapFromJson(content, Greeting.class); 
		Assert.assertNotNull("Not Null", createdGreeting);
		Assert.assertNotNull("not null of id",createdGreeting.getId());
		Assert.assertEquals("Equalization of text", greeting.getText(), createdGreeting.getText());
		
	}

	
	@Test 
	public void testUpdateGreeting() throws Exception {
		String uri = "/api/greetings/{id}"; 
		Long id = new Long(1); 
		Greeting testGreeting = getSingleEntitySubData(); 
		testGreeting.setText(testGreeting.getText()+"test");
		when(greetingService.update(any(Greeting.class))).thenReturn(testGreeting);
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
		verify(greetingService,times(1)).update(any(Greeting.class));
		
		Greeting updatedGreeting = super.mapFromJson(content, Greeting.class); 
		Assert.assertNotNull("Not Null", updatedGreeting);
		Assert.assertEquals("Equalization of id", testGreeting.getId(),updatedGreeting.getId());
		Assert.assertEquals("Equalization of text", testGreeting.getText(), updatedGreeting.getText());
	}
	 
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
	        verify(greetingService,times(1)).delete(id);
	        Greeting deletedGreeting = greetingService.findOne(id);

	        Assert.assertNull("failure - expected greeting to be null",
	                deletedGreeting);

	    }
	private Collection<Greeting> getAllEntityListStabData() {
		Collection<Greeting> list = new ArrayList<Greeting>(); 
		list.add(getSingleEntitySubData());
		return list;
	}
	private Greeting getSingleEntitySubData() {
		Greeting aStabData = new Greeting(); 
		aStabData.setId(1L);
		aStabData.setText("This is stab OBJ");
		return aStabData;
	} 
}
