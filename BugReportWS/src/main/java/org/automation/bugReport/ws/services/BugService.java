package org.automation.bugReport.ws.services;

import java.util.Collection;
import org.automation.bugReport.ws.models.Bug;
public interface BugService {

	Bug create(Bug b);
	void delete(Long id);
	Bug find(Long id);
	Collection<Bug> findall();
	Bug update(Bug b);
	void evictCache();
}
