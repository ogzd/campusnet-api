package dk.dtu.campusnet.api.reader;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.Lists;

import dk.dtu.campusnet.api.data.UserInfo;

public class UserInfoReader implements DocumentReader {

	private Document document;
	
	@Override
	public UserInfoReader from(Document document) {
		this.document = document;
		return this;
	}

	public UserInfo getUserInfo() {
		Node userInfoNode = document.getChildNodes().item(0);
		
		return NodeParser.parseUserInfo(userInfoNode);
	}
	
	public List<UserInfo> getUserInfos() {
		NodeList userInfoNodes = document.getChildNodes().item(0)
										 .getChildNodes();
		List<UserInfo> userInfos = Lists.newArrayList();
		for(int i = 0; i < userInfoNodes.getLength(); ++i) {
			Node userInfoNode = userInfoNodes.item(i);
			userInfos.add(NodeParser.parseUserInfo(userInfoNode));
		}
		return userInfos;
	}
}
