package dk.dtu.campusnet.api.reader;

import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.Maps;

import dk.dtu.campusnet.api.data.Element;

public class ElementsReader implements DocumentReader {

	private Document document;
	
	@Override
	public ElementsReader from(Document document) {
		this.document = document;
		return this;
	}

	public Map<String, Element> getElements() {
		Map<String, Element> elements = Maps.newHashMap();
		NodeList elementGroupings = document.getChildNodes().item(0)
											.getChildNodes();
		for(int i = 0; i < elementGroupings.getLength(); ++i) {
			NodeList nodes = elementGroupings.item(i).getChildNodes();
			elements.putAll(parseElements(nodes));
		}
		return elements;
	}
	
	public Map<String, Element> getSubElements() {
		NodeList nodes = document.getChildNodes().item(0) // <Elements>
								 .getChildNodes();
		
		return parseElements(nodes);
	}
	
	private Map<String, Element> parseElements(NodeList nodes) {
		Map<String, Element> elements = Maps.newHashMap();
		for(int i = 0; i < nodes.getLength(); ++i) {
			Node node = nodes.item(i);
			Element element = NodeParser.parseElement(node);
			elements.put(element.getElementId(), element);
		}
		return elements;
	}	
}
