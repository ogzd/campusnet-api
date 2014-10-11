package dk.dtu.campusnet.api.reader;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.Lists;

import dk.dtu.campusnet.api.data.Message;

public class MessageReader implements DocumentReader {

	private Document document;
	
	@Override
	public MessageReader from(Document document) {
		this.document = document;
		return this;
	}
	
	public List<Message> getMessages() {
		NodeList groupMessageNodes = document.getChildNodes().item(0)
											 .getChildNodes();
		
		List<Message> messages = Lists.newArrayList();
		for(int i = 0; i < groupMessageNodes.getLength(); ++i) {
			Node messageNode = groupMessageNodes.item(i);
			messages.add(NodeParser.parseMessage(messageNode));
		}
		return messages;
	}
}
