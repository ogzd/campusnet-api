package dk.dtu.campusnet.api.data;

public class FeedInfo {

	private String feedUrl;
	
	protected FeedInfo() {
		
	}
	
	public static FeedInfoBuilder newBuilder() {
		return new FeedInfoBuilder();
	}
	
	protected void setFeedUrl(String feedUrl) {
		this.feedUrl = feedUrl;
	}
	
	public String getFeedUrl() {
		return feedUrl;
	}
	
}
