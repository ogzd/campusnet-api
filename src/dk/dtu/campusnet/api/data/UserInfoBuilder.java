package dk.dtu.campusnet.api.data;

public class UserInfoBuilder {

	private UserInfo userInfo;
	
	protected UserInfoBuilder() {
		userInfo = new UserInfo();
	}
	
	public UserInfoBuilder withGivenName(String givenName) {
		userInfo.setGivenName(givenName);
		return this;
	}
	
	public UserInfoBuilder withFamilyName(String familyName) {
		userInfo.setFamilyName(familyName);
		return this;
	}
	
	public UserInfoBuilder withUserId(String userId) {
		userInfo.setUserId(userId);
		return this;
	}
	
	public UserInfoBuilder withClosed(boolean closed) {
		userInfo.setClosed(closed);
		return this;
	}
	
	public UserInfoBuilder withEmail(String email) {
		userInfo.setEmail(email);
		return this;
	}
	
	public UserInfoBuilder withPreferredLanguage(String preferredLanguage) {
		userInfo.setPreferredLanguage(preferredLanguage);
		return this;
	}
	
	public UserInfo done() {
		return userInfo;
	}
	
}
