package dk.dtu.campusnet.api.reader;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.Lists;

import dk.dtu.campusnet.api.data.UserInfo;

public class ParticipantsReader implements DocumentReader {

	private Document document;
	
	@Override
	public ParticipantsReader from(Document document) {
		this.document = document;
		return this;
	}
	
	public List<UserInfo> getAdministrators() {
		return getParticipants("Administrator");
	}
	
	public List<UserInfo> getUsers() {
		return getParticipants("User");
	}
	
	public List<UserInfo> getAuthors() {
		return getParticipants("Author");
	}
	
	private List<UserInfo> getParticipants(String participantRole) {
		NodeList participantNodes = document.getChildNodes().item(0)
											.getChildNodes();
		List<UserInfo> participants = Lists.newArrayList();
		for(int i = 0; i < participantNodes.getLength(); ++i) {
			Node participantNode = participantNodes.item(i);
			String role = ReaderUtil.getAttributeValue(participantNode, "ACL");
			if(participantRole.equals(role)) {
				Node userInfoNode = participantNode.getFirstChild();
				participants.add(NodeParser.parseUserInfo(userInfoNode));
			}
		}
		return participants;
	}
 
}
