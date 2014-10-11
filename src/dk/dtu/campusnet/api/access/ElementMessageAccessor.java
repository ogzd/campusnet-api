package dk.dtu.campusnet.api.access;

import java.util.List;

import org.w3c.dom.Document;

import dk.dtu.campusnet.api.data.Message;
import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.MessageReader;
import dk.dtu.campusnet.api.reader.Reader;

public class ElementMessageAccessor implements IMessageAccessor {

	private String elementId;
	
	public ElementMessageAccessor(String elementId) {
		this.elementId = elementId;
	}
	
	@Override
	public List<Message> getNewestMessages() {
		return getNewestMessages(1, 10);
	}
	
	@Override
	public List<Message> getNewestMessages(int first, int amount) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Messages/Newest/From/%s/Returning/%s", 
				elementId, first, amount));
		return Reader.load(MessageReader.class, doc)
					 .getMessages();
	}

	@Override
	public List<Message> search(String query, int first, int amount) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Messages/Search?query=%s&first=%s&amount=%s", 
				elementId, first, amount));
		return Reader.load(MessageReader.class, doc)
					 .getMessages();
	}

}
