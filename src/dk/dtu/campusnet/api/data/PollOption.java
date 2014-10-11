package dk.dtu.campusnet.api.data;

public class PollOption {

	private String id;
	private String text;
	private int votes;
	private boolean isCorrectAnswer;
	private boolean currentUserHasVotedOnThis;
	
	protected PollOption() {
		
	}
	
	public static PollOptionBuilder newBuilder() {
		return new PollOptionBuilder();
	}
	
	public String getId() {
		return id;
	}
	protected void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	protected void setText(String text) {
		this.text = text;
	}
	public boolean isCurrentUserHasVotedOnThis() {
		return currentUserHasVotedOnThis;
	}
	protected void setCurrentUserHasVotedOnThis(boolean currentUserHasVotedOnThis) {
		this.currentUserHasVotedOnThis = currentUserHasVotedOnThis;
	}
	public boolean isCorrectAnswer() {
		return isCorrectAnswer;
	}
	protected void setCorrectAnswer(boolean isCorrectAnswer) {
		this.isCorrectAnswer = isCorrectAnswer;
	}
	public int getVotes() {
		return votes;
	}
	protected void setVotes(int votes) {
		this.votes = votes;
	}
	
	
}
