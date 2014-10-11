package dk.dtu.campusnet.api.reader;

import org.w3c.dom.Document;

public class LoginReader implements DocumentReader {

	private Document document;
	
	@Override
	public LoginReader from(Document document) {
		this.document = document;
		return this;
	}

	public String getLimitedPassword() {
		return document.getChildNodes().item(0) // xml node
				   	   .getChildNodes().item(0) // LimitedAccess node
			           .getAttributes().item(0) // password attribute
			           .getNodeValue();
	}
	
}
