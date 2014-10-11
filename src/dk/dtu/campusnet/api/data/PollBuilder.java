package dk.dtu.campusnet.api.data;

import java.util.Date;
import java.util.List;

public class PollBuilder {

	private Poll poll;
	
	protected PollBuilder() {
		poll = new Poll();
	}
	
	public PollBuilder withPollId(String pollId) {
		poll.setPollId(pollId);
		return this;
	}
	
	public PollBuilder withQuestion(String question) {
		poll.setQuestion(question);
		return this;
	}
	
	public PollBuilder withAuthorUserId(String authorUserId) {
		poll.setAuthorUserId(authorUserId);
		return this;
	}
	
	public PollBuilder withElementId(String elementId) {
		poll.setElementId(elementId);
		return this;
	}
	
	public PollBuilder withCreated(Date created) {
		poll.setCreated(created);
		return this;
	}
	
	public PollBuilder withIsActive(boolean isActive) {
		poll.setActive(isActive);
		return this;
	}
	
	public PollBuilder withResultsVisibility(String resultsVisibility) {
		poll.setResultsVisibility(resultsVisibility);
		return this;
	}
	
	public PollBuilder withClosing(Date closing) {
		poll.setClosing(closing);
		return this;
	}
	
	public PollBuilder withCurrentUserHasVoted(boolean currentUserHasVoted) {
		poll.setCurrentUserHasVoted(currentUserHasVoted);
		return this;
	}
	
	public PollBuilder withCurrentUserCanVote(boolean currentUserCanVote) {
		poll.setCurrentUserCanVote(currentUserCanVote);
		return this;
	}
	
	public PollBuilder withType(String type) {
		poll.setType(type);
		return this;
	}
	
	public PollBuilder withElement(Element element) {
		poll.setElement(element);
		return this;
	}
	
	public PollBuilder withUserInfo(UserInfo userInfo) {
		poll.setUserInfo(userInfo);
		return this;
	}
	
	public PollBuilder withPollOptions(List<PollOption> pollOptions) {
		poll.setPollOptions(pollOptions);
		return this;
	}
	
	public Poll done() {
		return poll;
	}
	
}
