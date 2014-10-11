package dk.dtu.campusnet.api.access;

import java.util.List;

import org.w3c.dom.Document;

import dk.dtu.campusnet.api.data.UserInfo;
import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.Reader;
import dk.dtu.campusnet.api.reader.UserInfoReader;

public class UserInfoAccessor {
	
	public UserInfo getUserInfo() {
		Document doc = Request.get("https://www.campusnet.dtu.dk/data/CurrentUser/UserInfo");
		return Reader.load(UserInfoReader.class, doc)
				     .getUserInfo();
	}
	
	public UserInfo getUserInfo(String userId) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Users/%s", userId));
		return Reader.load(UserInfoReader.class, doc)
				     .getUserInfo();
	}
	
	public byte[] getUserPicture(String userId) {
		return Request.file(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Users/%s/Picture", userId));
	}
	
	public byte[] getUserPicture(String userId, int width) {
		return Request.file(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Users/%s/Picture/Width/%s", userId, width));
	}
	
	public List<UserInfo> search(String query, int first, int amount) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Users/Search?query=%s&first=%s&amount=%s",
				query, first, amount));
		Reader.printDocument(doc, System.out);
		return Reader.load(UserInfoReader.class, doc)
					 .getUserInfos();
	}
}
