package dk.dtu.campusnet.api.access;

import java.util.List;

import dk.dtu.campusnet.api.data.Message;

public interface IMessageAccessor {

	/**
	 * Returns 10 newest messages from integrated groups.
	 * Format: By giving an accept header when requesting, you can choose between formats. The default 
	 * format is text/html.
	 * @return
	 */
	public List<Message> getNewestMessages();
	
	/**
	 * Returns amount newest messages integrated groups, starting from first.
	 * @param first
	 * @param amount
	 * @return
	 */
	public List<Message> getNewestMessages(int first, int amount);
	
	
	/**
	 * Performs a search for messages that are not expired. It searches in your active groups in the CampusNet 
	 * database using query as the search string. The search algorithm supports double quotes for exact matches
	 * and the exclusion operator “-“.
	 * The parameters first and amount control which portion of the search results are shown. These are 
	 * optional and default to 1 and 20, respectively. The maximum value for both values is 100.
	 * If more parameters are added to the specification at some point, they will be optional as well.
	 * @param query
	 * @param first
	 * @param amount
	 * @return
	 */
	public List<Message> search(String query, int first, int amount);
}
