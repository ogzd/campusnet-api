package dk.dtu.campusnet.api.access;

import java.util.List;

import org.w3c.dom.Document;

import dk.dtu.campusnet.api.data.Cafeteria;
import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.CafeteriaReader;
import dk.dtu.campusnet.api.reader.Reader;

public class CafeteriaAccessor {

	public List<Cafeteria> getCafeterias() {
		Document doc = Request.get("https://www.campusnet.dtu.dk/data/CurrentUser/Cafeteria");
		return Reader.load(CafeteriaReader.class, doc)
					 .getCafeterias();
	}
	
}
