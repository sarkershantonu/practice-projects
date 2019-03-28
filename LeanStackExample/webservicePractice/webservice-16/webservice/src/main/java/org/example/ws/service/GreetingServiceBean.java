package org.example.ws.service;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import org.example.ws.model.Greeting;
import org.example.ws.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class GreetingServiceBean implements GreetingService{

	@Autowired
	private GreetingRepository greetingRepository; 
	@Autowired
	private CounterService counterService; 
		
	@Override
	public Collection<Greeting> findAll() {
		counterService.increment("org.example.ws.service.GreetingServiceBean.findAll.invoked");
		Collection<Greeting> greetings = greetingRepository.findAll();
		return greetings;
	}

	@Override
	@Cacheable(value="greetings", key ="#id" )// will stored idex using method parameter id
	public Greeting findOne(Long id) {
		counterService.increment("org.example.ws.service.GreetingServiceBean.findOne.invoked");
		Greeting greeting = greetingRepository.findOne(id);
		return greeting;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@CachePut(value="greetings", key="#result.id")
	public Greeting create(Greeting g) {
		counterService.increment("org.example.ws.service.GreetingServiceBean.Create.invoked");
		if(g.getId()!=null){
			throw new EntityExistsException("The id attribute must be null to persist a new entity.");
		}
		Greeting savedgreeting = greetingRepository.save(g);
		
		// if id 4 -> runtime exception 
		/*
		if(savedgreeting.getId()==4){
			throw new RuntimeException(); 
		}*/
		return savedgreeting;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@CachePut(value="greetings", key="#g.id")
	public Greeting update(Greeting g) {
		counterService.increment("org.example.ws.service.GreetingServiceBean.update.invoked");
		Greeting got = findOne(g.getId()); 
		if(got==null){// not in DB
			//return null;
			throw new NoResultException("Requested entity not found");
		}
		Greeting updatedgreeting = greetingRepository.save(g);
		return updatedgreeting;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@CacheEvict(value="greetings", key="#id")
	public void delete(Long id) {
		counterService.increment("org.example.ws.service.GreetingServiceBean.delete.invoked");
		greetingRepository.delete(id);
		
	}

	@Override
	@CacheEvict(value="greetings", allEntries=true)
	public void evictCache() {		
	}
	
}
