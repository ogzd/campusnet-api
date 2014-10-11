package dk.dtu.campusnet.api;

import java.util.Map;

import org.w3c.dom.Document;

import dk.dtu.campusnet.api.access.CafeteriaAccessor;
import dk.dtu.campusnet.api.access.EducationProgrammeAccessor;
import dk.dtu.campusnet.api.access.UserCalendarAccessor;
import dk.dtu.campusnet.api.access.UserInfoAccessor;
import dk.dtu.campusnet.api.access.UserMessageAccessor;
import dk.dtu.campusnet.api.access.UserPollAccessor;
import dk.dtu.campusnet.api.data.Element;
import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.ElementsReader;
import dk.dtu.campusnet.api.reader.Reader;

public class User {

	private Map<String, Element> elements;
	
	protected User() {
		loadCoursesAndGroups();
	}
	
	private void loadCoursesAndGroups() {
		Document doc = Request.get("https://www.campusnet.dtu.dk/data/CurrentUser/Elements");
		
		ElementsReader reader = Reader.load(ElementsReader.class, doc);
		
		elements = reader.getElements();
		
		for(Element element : elements.values()) {
			loadSubElements(element);
		}
	}
	
	// TODO: Let's hope that there are no cycles.
	private void loadSubElements(Element parentElement) {
		String parentElementId = parentElement.getElementId();
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Elements", parentElementId));
		
		ElementsReader reader = Reader.load(ElementsReader.class, doc);
		
		Map<String, Element> subElements = reader.getSubElements();
		
		for(Element subElement : subElements.values()) {
			parentElement.addElement(subElement);
			loadSubElements(subElement);
		}
	}
	
	// TODO: Throw ElementNotFoundException
	public Element getElementById(String elementId) {
		return elements.get(elementId);
	}
	
	// TODO: Throw ElementNotFoundException
	public Element getElementByName(String name) {
		for(Element element : elements.values()) {
			if(element.getName().equals(name))
				return element;
		}
		return null;
	}
	
	public UserCalendarAccessor getCalendarAccessor() {
		return new UserCalendarAccessor();
	}
	
	public UserMessageAccessor getMessageAccessor() {
		return new UserMessageAccessor();
	}
	
	public UserInfoAccessor getInfoAccessor() {
		return new UserInfoAccessor();
	}
	
	public UserPollAccessor getPollAccessor() {
		return new UserPollAccessor();
	}
	
	public EducationProgrammeAccessor getEducationProgrammeAccessor() {
		return new EducationProgrammeAccessor();
	}
	
	public CafeteriaAccessor getCafeteriaAccessor() {
		return new CafeteriaAccessor();
	}
}
