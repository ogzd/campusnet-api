package dk.dtu.campusnet.api.data;

public class UserInfo {

	private String givenName;
	private String familyName;
	private String userId;
	private boolean closed;
	private String email;
	private String preferredLanguage;
	
	protected UserInfo() {
		
	}
	
	public static UserInfoBuilder newBuilder() {
		return new UserInfoBuilder();
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	protected void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	protected void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getUserId() {
		return userId;
	}
	
	protected void setUserId(String userId) {
		this.userId = userId;
	}
	
	public boolean isClosed() {
		return closed;
	}
	
	protected void setClosed(boolean closed) {
		this.closed = closed;
	}
	
	public String getEmail() {
		return email;
	}
	
	protected void setEmail(String email) {
		this.email = email;
	}
	
	public String getPreferredLanguage() {
		return preferredLanguage;
	}
	
	protected void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
}
