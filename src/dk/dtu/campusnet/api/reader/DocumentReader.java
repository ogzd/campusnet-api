package dk.dtu.campusnet.api.reader;

import org.w3c.dom.Document;

public interface DocumentReader {

	/**
	 * Initialize reader object with an HTML/XML document.
	 * @param document
	 * @return
	 */
	public DocumentReader from(Document document);
	
}
