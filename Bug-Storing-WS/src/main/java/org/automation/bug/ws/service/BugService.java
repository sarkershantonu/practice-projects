package org.automation.bug.ws.service;

import org.automation.bug.ws.model.Bug;

import java.util.Collection;

/**
 * Created by shantonu on 12/18/16.
 */
public interface BugService {
    Collection<Bug> findAll();
    Bug findOne(Long id);
    Bug create(Bug g);
    Bug update(Bug g);
    void delete(Long id);
    void evictCache();
}
