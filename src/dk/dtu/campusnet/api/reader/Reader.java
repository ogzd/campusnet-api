package dk.dtu.campusnet.api.reader;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Reader {
	
	private static <T extends DocumentReader> T init(Class<T> readerClass) {
		try {
			return readerClass.newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends DocumentReader> T load(Class<T> readerClass, Document doc) {
		return (T) init(readerClass).from(doc);
	}
	
	/**
	 * Prints a document to an output stream, for debug purposes.
	 * @param doc
	 * @param out
	 * @throws IOException
	 * @throws TransformerException
	 */
	public static void printDocument(Document doc, OutputStream out) {
	    try {
			TransformerFactory tf = TransformerFactory.newInstance();
		    Transformer transformer = tf.newTransformer();
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	
		    transformer.transform(new DOMSource(doc), 
		         new StreamResult(new OutputStreamWriter(out, "UTF-8")));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
}
