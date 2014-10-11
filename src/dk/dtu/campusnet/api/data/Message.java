package dk.dtu.campusnet.api.data;

import java.util.Date;

public class Message {

	private String authorUserId;
	private String body;
	private String elementId;
	private String subject;
	private Date   updated;
	
	protected Message() {
		
	}
	
	public static MessageBuilder newBuilder() {
		return new MessageBuilder();
	}
	
	public String getAuthorUserId() {
		return authorUserId;
	}
	protected void setAuthorUserId(String authorUserId) {
		this.authorUserId = authorUserId;
	}
	public String getBody() {
		return body;
	}
	protected void setBody(String body) {
		this.body = body;
	}
	public String getElementId() {
		return elementId;
	}
	protected void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public String getSubject() {
		return subject;
	}
	protected void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getUpdated() {
		return updated;
	}
	protected void setUpdated(Date updated) {
		this.updated = updated;
	}
	
}
