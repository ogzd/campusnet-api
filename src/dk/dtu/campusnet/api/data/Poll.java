package dk.dtu.campusnet.api.data;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class Poll {

	private String pollId;
	private String question;
	private String authorUserId;
	private String elementId;
	private Date created;
	private boolean isActive;
	private String resultsVisibility;
	private Date closing;
	private boolean currentUserHasVoted;
	private boolean currentUserCanVote;
	private String type;
	private UserInfo userInfo;
	private Element element;
	private List<PollOption> pollOptions;
	
	protected Poll() {
		pollOptions = Lists.newArrayList();
	}
	
	public static PollBuilder newBuilder() {
		return new PollBuilder();
	}
	
	public String getPollId() {
		return pollId;
	}
	protected void setPollId(String pollId) {
		this.pollId = pollId;
	}
	public String getQuestion() {
		return question;
	}
	protected void setQuestion(String question) {
		this.question = question;
	}
	public String getAuthorUserId() {
		return authorUserId;
	}
	protected void setAuthorUserId(String authorUserId) {
		this.authorUserId = authorUserId;
	}
	public String getElementId() {
		return elementId;
	}
	protected void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public Date getCreated() {
		return created;
	}
	protected void setCreated(Date created) {
		this.created = created;
	}
	public boolean isActive() {
		return isActive;
	}
	protected void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getResultsVisibility() {
		return resultsVisibility;
	}
	protected void setResultsVisibility(String resultsVisibility) {
		this.resultsVisibility = resultsVisibility;
	}
	public Date getClosing() {
		return closing;
	}
	protected void setClosing(Date closing) {
		this.closing = closing;
	}
	public boolean isCurrentUserHasVoted() {
		return currentUserHasVoted;
	}
	protected void setCurrentUserHasVoted(boolean currentUserHasVoted) {
		this.currentUserHasVoted = currentUserHasVoted;
	}
	public boolean isCurrentUserCanVote() {
		return currentUserCanVote;
	}
	protected void setCurrentUserCanVote(boolean currentUserCanVote) {
		this.currentUserCanVote = currentUserCanVote;
	}
	public String getType() {
		return type;
	}
	protected void setType(String type) {
		this.type = type;
	}
	public UserInfo getUser() {
		return userInfo;
	}
	protected void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public List<PollOption> getPollOptions() {
		return pollOptions;
	}
	protected void setPollOptions(List<PollOption> pollOptions) {
		this.pollOptions = pollOptions;
	}
	public Element getElement() {
		return element;
	}
	protected void setElement(Element element) {
		this.element = element;
	}
}
