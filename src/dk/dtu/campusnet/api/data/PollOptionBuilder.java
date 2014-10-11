package dk.dtu.campusnet.api.data;

public class PollOptionBuilder {

	private PollOption pollOption;
	
	protected PollOptionBuilder() {
		
	}
	
	public PollOptionBuilder withId(String id) {
		pollOption.setId(id);
		return this;
	}
	
	public PollOptionBuilder withText(String text) {
		pollOption.setText(text);
		return this;
	}
	
	public PollOptionBuilder withCurrentUserHasVotedOnThis(boolean currentUserHasVotedOnThis) {
		pollOption.setCurrentUserHasVotedOnThis(currentUserHasVotedOnThis);
		return this;
	}
	
	public PollOptionBuilder withVotes(int votes) {
		pollOption.setVotes(votes);
		return this;
	}
	
	public PollOptionBuilder withIsCorrectAnswer(boolean isCorrectAnswer) {
		pollOption.setCorrectAnswer(isCorrectAnswer);
		return this;
	}
	
	public PollOption done() {
		return pollOption;
	}
	
}
