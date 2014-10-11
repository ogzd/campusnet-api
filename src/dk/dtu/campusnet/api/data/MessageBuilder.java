package dk.dtu.campusnet.api.data;

import java.util.Date;

public class MessageBuilder {

	private Message message;
	
	protected MessageBuilder() {
		message = new Message();
	}
	
	public MessageBuilder withAuthorUserId(String authorUserId) {
		message.setAuthorUserId(authorUserId);
		return this;
	}
	
	public MessageBuilder withElementId(String elementId) {
		message.setElementId(elementId);
		return this;
	}
	
	public MessageBuilder withBody(String body) {
		message.setBody(body);
		return this;
	}
	
	public MessageBuilder withSubject(String subject) {
		message.setSubject(subject);
		return this;
	}
	
	public MessageBuilder withUpdated(Date updated) {
		message.setUpdated(updated);
		return this;
	}
	
	public Message done() {
		return message;
	}
}
