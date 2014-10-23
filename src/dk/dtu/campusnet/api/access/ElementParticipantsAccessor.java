package dk.dtu.campusnet.api.access;

import java.util.List;

import org.w3c.dom.Document;

import dk.dtu.campusnet.api.data.UserInfo;
import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.ParticipantsReader;
import dk.dtu.campusnet.api.reader.Reader;

public class ElementParticipantsAccessor implements IParticipantsAccessor {

	private String elementId;
	
	public ElementParticipantsAccessor(String elementId) {
		this.elementId = elementId;
	}
	
	public List<UserInfo> getAdministrators() {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Participants", elementId));
		return Reader.load(ParticipantsReader.class, doc)
					 .getAdministrators();
	}
	
	public List<UserInfo> getUsers() {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Participants", elementId));
		return Reader.load(ParticipantsReader.class, doc)
					 .getUsers();
	}
	
	public List<UserInfo> getAuthors() {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Participants", elementId));
		return Reader.load(ParticipantsReader.class, doc)
					 .getAuthors();
	}
}
