package dk.dtu.campusnet.api.reader;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.google.common.collect.Lists;

import dk.dtu.campusnet.api.data.Appointment;

public class CalendarReader implements DocumentReader {
	
	private Document document;
	
	@Override
	public CalendarReader from(Document document) {
		this.document = document;
		return this;
	}

	public List<Appointment> getAppointments() {
		Node firstEntryNode = document.getChildNodes().item(0)
									  .getChildNodes().item(0);
	
		List<Appointment> appointments = Lists.newArrayList();
		for(Node entryNode = firstEntryNode; 
				 entryNode != null; 
				 entryNode = entryNode.getNextSibling()) {
			if(entryNode.getNodeName().equals("entry")) {
				appointments.add(NodeParser.parseAppointment(entryNode));
			}	
		}
		return appointments;
	}
}
