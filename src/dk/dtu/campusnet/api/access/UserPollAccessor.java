package dk.dtu.campusnet.api.access;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

import dk.dtu.campusnet.api.data.Poll;
import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.PollReader;
import dk.dtu.campusnet.api.reader.Reader;

public class UserPollAccessor {

	public List<Poll> getActivePolls(int first, int amount) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Polls/From/%s/Returning/%s", 
				first, amount));
		Reader.printDocument(doc, System.out);
		return Reader.load(PollReader.class, doc)
				     .getActivePolls();
	}
	
	public List<Poll> getInactivePolls(int first, int amount) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Polls/From/%s/Returning/%s", 
				first, amount));
		return Reader.load(PollReader.class, doc)
				     .getInactivePolls();
	}
	
	public Poll getPoll(String pollId) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Polls/%s", pollId));
		return Reader.load(PollReader.class, doc)
				     .getPoll();
	}
	
	public Poll getPollResult(String pollId) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Polls/%s/Results", pollId));
		return Reader.load(PollReader.class, doc)
					 .getPoll();
	}
	
	public void vote(String pollId, List<String> pollOptionIds) {
		String optionIds = Joiner.on(",").join(pollOptionIds);
		Map<String, String> data = new ImmutableMap.Builder<String, String>()
												   .put("optionIds", optionIds)
												   .build();
		Request.post(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Polls/%s/Vote", pollId), data, true);
	}
}
