package dk.dtu.campusnet.api.reader;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import dk.dtu.campusnet.api.data.FeedInfo;

public class FeedInfoReader implements DocumentReader {

	private Document document;
	
	@Override
	public FeedInfoReader from(Document document) {
		this.document = document;
		return this;
	}

	public FeedInfo getFeedInfo() {
		Node icalNode = document.getChildNodes().item(0)
								.getChildNodes().item(0);
		return NodeParser.parseFeedInfo(icalNode);
	}
}
