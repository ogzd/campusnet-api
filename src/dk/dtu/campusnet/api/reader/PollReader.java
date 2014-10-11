package dk.dtu.campusnet.api.reader;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.Lists;

import dk.dtu.campusnet.api.data.Poll;

public class PollReader implements DocumentReader {

	private Document document;
	
	@Override
	public PollReader from(Document document) {
		this.document = document;
		return this;
	}
	
	public List<Poll> getActivePolls() {
		NodeList activePollNodes   = document.getChildNodes().item(0)
			     							 .getChildNodes().item(0)
			     							 .getChildNodes();
		return parsePolls(activePollNodes);
	}
	
	public List<Poll> getInactivePolls() {
		NodeList inactivePolls = document.getChildNodes().item(0)
										 .getChildNodes().item(1)
										 .getChildNodes();
		return parsePolls(inactivePolls);
	}
	
	public Poll getPoll() {
		Node pollNode = document.getFirstChild();
		
		return NodeParser.parsePoll(pollNode);
	}
	
	private List<Poll> parsePolls(NodeList pollNodes) {
		List<Poll> polls = Lists.newArrayList();
		for(int i = 0; i < pollNodes.getLength(); ++i) {
			Node pollNode = pollNodes.item(i);
			polls.add(NodeParser.parsePoll(pollNode));
		}
		return polls;
	}
}
