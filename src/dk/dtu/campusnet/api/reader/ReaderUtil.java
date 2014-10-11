package dk.dtu.campusnet.api.reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReaderUtil {

	private final static String DATE_PATTERN_FROM = "yyyy-MM-dd'T'HH:mm:ss";
	private final static String DATE_PATTERN_TO   = "yyyy-MM-dd";
	
	/**
	 * Parses date in the following pattern: "2014-07-23T21:29:37.053"
	 * @param dateString
	 * @return
	 */
	public static Date parseDate(String dateString) {
		try {
			return new SimpleDateFormat(DATE_PATTERN_FROM).parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}
	
	/**
	 * Converts a date object to string representation using date pattern.
	 * @param date
	 * @return
	 */
	public static String toString(Date date) {
		return new SimpleDateFormat(DATE_PATTERN_TO).format(date);
	}
	
	/**
	 * Returns attribute value from node if that attribute is present, otherwise null.
	 * @return
	 */
	public static String getAttributeValue(Node node, String attribute) {
		Node namedItem = node.getAttributes().getNamedItem(attribute);
		return namedItem == null ? null : namedItem.getNodeValue();
	}
	
	/**
	 * Returns child node of a parent node by searching for node name.
	 * @param node
	 * @param childNodeName
	 * @return
	 */
	public static Node getChildNodeByName(Node node, String childNodeName) {
		NodeList childNodes = node.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); ++i) {
			if(childNodes.item(i).getNodeName().equals(childNodeName)) {
				return childNodes.item(i);
			}
		}
		return null;
	}
}
