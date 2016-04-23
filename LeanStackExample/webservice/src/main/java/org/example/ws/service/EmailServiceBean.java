package org.example.ws.service;

import java.util.concurrent.Future;

import org.example.ws.model.Greeting;
import org.example.ws.util.AsyncResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceBean implements EmailService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Boolean send(Greeting greeting) {
		logger.info("send--------- started");
		Boolean success = Boolean.FALSE; 
		long pause = 5000; 
		try{
			Thread.sleep(pause); 
			System.out.println("Mail send simulation for -> "+ greeting.getText());
		}catch(Exception e){
			logger.warn("Exception found in send ", e);
		}
		logger.info("Sending time was {} sec", pause/1000);
		success= Boolean.TRUE;
		logger.info("send--------- ended");
		return success;
	}

	@Async
	@Override
	public void sendAsync(Greeting greeting) {
		logger.info("sendAsync--------- started");
		try {
			send(greeting);
		} catch (Exception e) {
			logger.warn("Exception found ", e);
		}
		logger.info("sendAsync--------- Stopped ");
	}

	@Async
	@Override
	public Future<Boolean> sendAsyncWithResult(Greeting greeting) {

		logger.info("sendAsyncWithResult--------- started");
		AsyncResponse<Boolean> asyncResponses = new AsyncResponse<Boolean>();
		try {
			Boolean success = send(greeting);
			asyncResponses.complete(success);
		} catch (Exception e) {
			logger.warn("Exception found ", e);
			asyncResponses.completedExceptionally(e);
		}
		logger.info("sendAsyncWithResult--------- Stopped ");
		return asyncResponses;
	}

}
