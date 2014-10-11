package dk.dtu.campusnet.api;

import java.util.Map;

import org.w3c.dom.Document;

import com.google.common.collect.Maps;

import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.LoginReader;
import dk.dtu.campusnet.api.reader.Reader;


public class Api {

	private static final String LOGINURL = "https://auth.dtu.dk/dtu/mobilapp.jsp";
	
	public static User login(String username, String password) {
		Map<String, String> params = Maps.newHashMap();
		params.put("username", username);
		params.put("password", password);
		
		String limitedPassword = loginAndGetPassword(params);
		
		Request.cache("username", username);
		Request.cache("limitedPassword", limitedPassword);
		
		return new User();
	}
	
	private static String loginAndGetPassword(Map<String, String> params) {
		Document doc = Request.post(LOGINURL, params, false);
		
		LoginReader reader     = Reader.load(LoginReader.class, doc);
		String limitedPassword = reader.getLimitedPassword();
		
		return limitedPassword;
	}
}
