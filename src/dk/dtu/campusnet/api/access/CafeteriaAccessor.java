package dk.dtu.campusnet.api.access;

import org.w3c.dom.Document;

import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.Reader;

public class CafeteriaAccessor {

	public void getMenus() {
		Document doc = Request.get("https://www.campusnet.dtu.dk/data/CurrentUser/Cafeteria");
		Reader.printDocument(doc, System.out);
	}
	
}
