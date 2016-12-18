package org.automation.bugReport.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class Application
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);    	
        System.out.println( "This is simple bug storing DB as Rest Service" );
    }
    @Bean
    public CacheManager enableCaching(){
    	return new GuavaCacheManager("bugs");//cache support to store bugs 
    }
}
