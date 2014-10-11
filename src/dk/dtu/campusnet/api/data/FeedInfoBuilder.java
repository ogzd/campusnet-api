package dk.dtu.campusnet.api.data;

public class FeedInfoBuilder {

	private FeedInfo feedInfo;
	
	protected FeedInfoBuilder() {
		feedInfo = new FeedInfo();
	}
	
	public FeedInfoBuilder withFeedUrl(String feedUrl) {
		feedInfo.setFeedUrl(feedUrl);
		return this;
	}
	
	public FeedInfo done() {
		return feedInfo;
	}
}
