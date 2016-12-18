package org.automation.bug.ws.repo;

import org.automation.bug.ws.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shantonu on 12/18/16.
 */
public interface BugRepository extends JpaRepository<Bug, Long>{
}
