package org.example.ws.batch;

import java.util.Collection;

import org.example.ws.model.Greeting;
import org.example.ws.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Profile("batch")
@Component
public class GreetingBatchBean {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GreetingService greetingService; 
	
	@Scheduled(cron="${batch.greetings.corn}")
	public void cronJOb(){
		logger.info("Cron Job-------------- Started ");

		//create db 
		Collection<Greeting> greetings = greetingService.findAll(); 
		logger.info("There are {} greetings in the data source ", greetings.size());
		
		
		logger.info("Cron Job-------------- Ended ");
	}
	
	@Scheduled(initialDelayString = "${batch.greetings.initialdelay}", fixedRateString="${batch.greetings.fixeddelay}")// first one in 5s, then every 15s(measure from starting of a job
	public void fixedRateJobWithInitialDelay(){
		logger.info("fixedRateJobWithInitialDelay-------------- started");
		long pause = 5000; 
		long start = System.currentTimeMillis(); 
		do{
			if(start+pause<System.currentTimeMillis()){
				break;
			}
		}while(true);
		logger.info(" processing time was {} sec. ",pause/1000);
		logger.info("fixedRateJobWithInitialDelay-------------- Stopped");
	}
	@Scheduled(initialDelayString = "${batch.greetings.initialdelay}", fixedDelayString="${batch.greetings.fixeddelay}")//first one in 5s, then delay 15s, measures previous job end  
		public void fixedDelayJobWithInitialDelay(){
			logger.info("fixedRateJobWithInitialDelay-------------- started");
			long pause = 5000; 
			long start = System.currentTimeMillis(); 
			do{
				if(start+pause<System.currentTimeMillis()){
					break;
				}
			}while(true);
			logger.info(" processing time was {} sec. ",pause/1000);
			logger.info("fixedRateJobWithInitialDelay-------------- Stopped");
		}

}
