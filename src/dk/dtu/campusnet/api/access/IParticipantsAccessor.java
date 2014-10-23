package dk.dtu.campusnet.api.access;

import java.util.List;

import dk.dtu.campusnet.api.data.UserInfo;

public interface IParticipantsAccessor {

	/**
	 * Returns a list of UserInfo who have author access to an element. 
	 * @return
	 */
	public List<UserInfo> getAuthors();
	
	/**
	 * Returns a list of UserInfo who have administrator access to an element.
	 * @return
	 */
	public List<UserInfo> getAdministrators();
	
	/**
	 * Returns a list of UserInfo who have user access to an element.
	 * @return
	 */
	public List<UserInfo> getUsers();
	
}
