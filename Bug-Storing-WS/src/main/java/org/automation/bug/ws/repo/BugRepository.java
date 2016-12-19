package org.automation.bug.ws.repo;

import org.automation.bug.ws.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shantonu on 12/18/16.
 */
@Repository
public interface BugRepository extends JpaRepository<Bug, Long>{
}
