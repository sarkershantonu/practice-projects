package org.automation.bugReport.ws.web.api;

import java.util.Collection;

import org.automation.bugReport.ws.models.Bug;
import org.automation.bugReport.ws.services.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugWSController extends BaseController {

	@Autowired
	private BugService bugService;

	@RequestMapping(value = "/api/bugs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bug> getABug(@PathVariable("id") Long id) {
		Bug foundBug = bugService.find(id);
		if (foundBug == null) {
			return new ResponseEntity<Bug>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Bug>(foundBug, HttpStatus.OK);
	}

	@RequestMapping(value =  "/api/bugs" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Bug>> getAllBugs() {
		Collection<Bug> allBugs = this.bugService.findall();
		return new ResponseEntity<Collection<Bug>>(allBugs, HttpStatus.OK);
	}

	@RequestMapping(value =  "/api/bugs" , method =  RequestMethod.POST , consumes =  MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bug> createABug(@RequestBody Bug entry) {
		Bug aNewBug = this.bugService.create(entry);
		if (aNewBug == null) {
			return new ResponseEntity<Bug>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Bug>(aNewBug, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/bugs/{id}" , method = RequestMethod.PUT , consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bug> update(@RequestBody Bug entry, @PathVariable("id") Long id) {
		if (id != entry.getId()) {
			return new ResponseEntity<Bug>(HttpStatus.NOT_FOUND);
		}
		Bug edited = this.bugService.update(entry);
		if (edited == null) {
			return new ResponseEntity<Bug>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Bug>(edited, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/api/bugs/{id}" , method = RequestMethod.DELETE , consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bug> delete(@PathVariable("id") Long id) {
		this.bugService.delete(id);
		return new ResponseEntity<Bug>(HttpStatus.NO_CONTENT);
	}
}
