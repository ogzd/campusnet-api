package dk.dtu.campusnet.api.reader;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.Lists;

import dk.dtu.campusnet.api.data.EducationProgramme;

public class EducationProgrammeReader implements DocumentReader {

	private Document document;
	
	@Override
	public DocumentReader from(Document document) {
		this.document = document;
		return this;
	}
	
	public List<EducationProgramme> getEducationProgrammes() {
		NodeList educationProgrammeNodes = document.getChildNodes().item(0)
												   .getChildNodes();
	
		List<EducationProgramme> educationProgrammes = Lists.newArrayList();
		for(int i = 0; i < educationProgrammeNodes.getLength(); ++i) {
			Node educationProgrammeNode = educationProgrammeNodes.item(i);
			educationProgrammes.add(NodeParser.parseEducationProgramme(educationProgrammeNode));
		}
		return educationProgrammes;
	}
}
