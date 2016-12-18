package org.automation.bugReport.ws.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Bug {
	
	@Id
	@GeneratedValue
	private Long id;

	private String title;
	private String summary;
	private String Description;
	private String AttachmentPath;
	private String exceptions;
	private String logs;
	private String foundDateTime;
	private String foundTags;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAttachmentPath() {
		return AttachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		AttachmentPath = attachmentPath;
	}
	public String getExceptions() {
		return exceptions;
	}
	public void setExceptions(String exceptions) {
		this.exceptions = exceptions;
	}
	public String getLogs() {
		return logs;
	}
	public void setLogs(String logs) {
		this.logs = logs;
	}
	public String getFoundDateTime() {
		return foundDateTime;
	}
	public void setFoundDateTime(String foundDateTime) {
		this.foundDateTime = foundDateTime;
	}
	public String getFoundTags() {
		return foundTags;
	}
	public void setFoundTags(String foundTags) {
		this.foundTags = foundTags;
	}
}
