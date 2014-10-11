package dk.dtu.campusnet.api.reader;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.Lists;

import dk.dtu.campusnet.api.data.Cafeteria;

public class CafeteriaReader implements DocumentReader {

	private Document document;
	
	@Override
	public CafeteriaReader from(Document document) {
		this.document = document;
		return this;
	}
	
	public List<Cafeteria> getCafeterias() {
		NodeList cafeteriaNodes = document.getChildNodes().item(0)
										  .getChildNodes(); 
		List<Cafeteria> cafeterias = Lists.newArrayList();
		for(int i = 0; i < cafeteriaNodes.getLength(); ++i) {
			Node cafeteriaNode = cafeteriaNodes.item(i);
			cafeterias.add(NodeParser.parseCafeteria(cafeteriaNode));
		}
		return cafeterias;
	}

}
