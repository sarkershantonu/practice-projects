package org.example.ws.web.api;

import java.util.Collection;
import java.util.concurrent.Future;

import org.apache.tomcat.jni.OS;
import org.example.ws.model.Greeting;
import org.example.ws.service.EmailService;
import org.example.ws.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController extends BaseController{
	
	@Autowired
	private GreetingService service; 
	@Autowired
	private EmailService emailService; 

	@RequestMapping(value = "/api/greetings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Greeting>> getAllGreeting() {
		Collection<Greeting> greets = service.findAll();
		return new ResponseEntity<Collection<Greeting>>(greets, HttpStatus.OK);

	}

	@RequestMapping(value = "/api/greetings/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> getGreeting(@PathVariable("id") Long id) {
		Greeting greet = service.findOne(id); 
		if (greet == null) {
			return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Greeting>(greet, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/greetings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> addGreeting(@RequestBody Greeting g) {
		Greeting saved = service.create(g);
		return new ResponseEntity<Greeting>(saved, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/greetings/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> delGreeting(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<Greeting>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/api/greetings/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> update(@RequestBody Greeting g, @PathVariable("id") Long id) {
		Greeting update;
		//update = service.update(g);
		
		if (g.getId().longValue()==id) {// checking if item is putting in right path
			update = service.update(g);
		} else {
			return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
		}
		if (update == null) {
			return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Greeting>(update, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/api/greetings/{id}/send", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> sendGreeting(@PathVariable("id") Long id, @RequestParam(value="wait", defaultValue = "false") boolean waitForAsyncResults)
	{
		logger.info("sendGreeting");
		Greeting greet=null; 
		try{
			greet = service.findOne(id);
			if(greet==null){
				logger.info("Sendng Null");
				return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
			}
			if(waitForAsyncResults){
				Future<Boolean> asyncResponses = emailService.sendAsyncWithResult(greet);
				boolean isEmailSent = asyncResponses.get();
				logger.info("Sending Mail Async with results {}", isEmailSent);
			}else
			{
				emailService.sendAsync(greet);
				logger.info("Sending Mail Async without result");
			}
			logger.info("Sending complete without exception ");
			
		}catch (Exception e)
		{
			logger.error("Error on sending greeting", e);
			return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
		return new ResponseEntity<Greeting>(greet, HttpStatus.OK);
		
		
	}
}
