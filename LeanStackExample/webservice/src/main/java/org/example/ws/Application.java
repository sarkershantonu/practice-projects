package org.example.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableAsync
public class Application 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    	
        System.out.println( "Application Started" );
    }
    
    @Bean
    public CacheManager cacheManager(){
    	GuavaCacheManager cacheManager = new GuavaCacheManager("greetings");
    	
    	//ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("greetings");
    	return cacheManager; 
    }
    
    
}
