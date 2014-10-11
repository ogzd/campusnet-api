package dk.dtu.campusnet.api.access;

import java.util.List;

import org.w3c.dom.Document;

import dk.dtu.campusnet.api.data.EducationProgramme;
import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.EducationProgrammeReader;
import dk.dtu.campusnet.api.reader.Reader;

public class EducationProgrammeAccessor {
	
	public List<EducationProgramme> getPrograms() {
		Document doc = Request.get("https://www.campusnet.dtu.dk/data/CurrentUser/Grades");
		
		return Reader.load(EducationProgrammeReader.class, doc)
					 .getEducationProgrammes();
	}
}
