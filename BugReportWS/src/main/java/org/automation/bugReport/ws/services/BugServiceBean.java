package org.automation.bugReport.ws.services;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import org.automation.bugReport.ws.models.Bug;
import org.automation.bugReport.ws.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class BugServiceBean implements BugService{
	@Autowired
	private BugRepository bugRepository;	
	//TOdo actuator matrix collection adding 

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=false)
	@CachePut(value="bugs", key="#result.id")
	public Bug create(Bug b) {
		if(b.getId()!=null){
			throw new EntityExistsException("Bug ID should be null for new bug");
		}
		return bugRepository.save(b);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=false)
	@CacheEvict(value="bugs", key="#id")
	public void delete(Long id) {
		bugRepository.delete(id);
	}

	@Override
	@Cacheable(value="bugs", key="#id")
	public Bug find(Long id) {
		return bugRepository.findOne(id);
	}

	@Override
	public Collection<Bug> findall() {
		return bugRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=false)
	@CachePut(value="bugs", key="#b.id")
	public Bug update(Bug b) {
		if(bugRepository.findOne(b.getId())==null){
			throw new NoResultException("Bug does not exsists");
		}
		return bugRepository.save(b);
	}

	@Override
	@CacheEvict(value="bugs", allEntries=true)
	public void evictCache() {
		// TODO Auto-generated method stub
		
	}

}
