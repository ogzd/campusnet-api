package dk.dtu.campusnet.api.reader;

import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.Lists;

import dk.dtu.campusnet.api.data.Appointment;
import dk.dtu.campusnet.api.data.Cafeteria;
import dk.dtu.campusnet.api.data.CreditResult;
import dk.dtu.campusnet.api.data.EducationProgramme;
import dk.dtu.campusnet.api.data.Element;
import dk.dtu.campusnet.api.data.ExamResult;
import dk.dtu.campusnet.api.data.FeedInfo;
import dk.dtu.campusnet.api.data.File;
import dk.dtu.campusnet.api.data.FileVersion;
import dk.dtu.campusnet.api.data.Folder;
import dk.dtu.campusnet.api.data.Menu;
import dk.dtu.campusnet.api.data.Menus;
import dk.dtu.campusnet.api.data.Message;
import dk.dtu.campusnet.api.data.PassedECTSSum;
import dk.dtu.campusnet.api.data.Poll;
import dk.dtu.campusnet.api.data.PollOption;
import dk.dtu.campusnet.api.data.UserInfo;

public class NodeParser {
	
	// TODO: Design decision, not parsing Danish language based information. Think about it.
	public static Appointment parseAppointment(Node entryNode) {
		String title     = entryNode.getChildNodes().item(0)  // <title>
								    .getTextContent();
		String updated   = entryNode.getChildNodes().item(1)  // <updated>
								    .getTextContent();
		String content   = entryNode.getChildNodes().item(2)  // <content>
								    .getTextContent();
		String link      = entryNode.getChildNodes().item(3)  // <link>
								    .getAttributes().getNamedItem("href")
								    .getNodeValue();
		String name      = entryNode.getChildNodes().item(5)  // <cn:element>
							        .getChildNodes().item(0)
							        .getTextContent();
		String href      = entryNode.getChildNodes().item(5)  // <cn:element>
				 			        .getChildNodes().item(1)
				 			        .getTextContent();
		String startDate = entryNode.getChildNodes().item(6)  // <cn:duration>
									.getAttributes().getNamedItem("StartTime")
									.getNodeValue();
		String endDate   = entryNode.getChildNodes().item(6)  // <cn:duration>
									.getAttributes().getNamedItem("EndTime")
									.getNodeValue();
		
		return Appointment.newBuilder()
					.withTitle(title)
					.withUpdatedDate(ReaderUtil.parseDate(updated))
					.withContent(content)
					.withLink(link)
					.withName(name)
					.withHref(href)
					.withStartDate(ReaderUtil.parseDate(startDate))
					.withEndDate(ReaderUtil.parseDate(endDate))
					.done();
	}
	
	public static Element parseElement(Node elementNode) {
		String contextName   = ReaderUtil.getAttributeValue(elementNode, "ContextName");
		String elementId     = ReaderUtil.getAttributeValue(elementNode, "Id");
		String isArchived    = ReaderUtil.getAttributeValue(elementNode, "IsArchived");
		String parentId      = ReaderUtil.getAttributeValue(elementNode, "ParentId");
		String name          = ReaderUtil.getAttributeValue(elementNode, "Name");
		String subgroupCount = ReaderUtil.getAttributeValue(elementNode, "SubgroupCount");
		
		return Element.newBuilder()
				   .withContextName(contextName)
				   .withElementId(elementId)
				   .withIsArchived(Boolean.valueOf(isArchived))
				   .withParentId(parentId)
				   .withName(name)
				   .withSubgroupCount(Integer.parseInt(subgroupCount))
				   .done();
	}
	
	public static FeedInfo parseFeedInfo(Node node) {
		String feedUrl = ReaderUtil.getAttributeValue(node, "Url");
		
		return FeedInfo.newBuilder()
				.withFeedUrl(feedUrl)
				.done();
	}

	public static Folder parseFolder(Node node, String elementId) {
		String folderId  = ReaderUtil.getAttributeValue(node, "Id");
		String mayUpload = ReaderUtil.getAttributeValue(node, "MayUpload");
		String created   = ReaderUtil.getAttributeValue(node, "Created");
		String name      = ReaderUtil.getAttributeValue(node, "Name");
		
		return Folder.newBuilder()
					.withElementId(elementId)
					.withFolderId(folderId)
					.withMayUpload(Boolean.valueOf(mayUpload))
					.withCreatedDate(ReaderUtil.parseDate(created))
					.withName(name)
					.done();
	}

	public static File parseFile(Node node, String elementId) {
		String fileId = ReaderUtil.getAttributeValue(node, "Id");
		String name   = ReaderUtil.getAttributeValue(node, "Name");
		
		return File.newBuilder()
				  .withElementId(elementId)
				  .withFileId(fileId)
				  .withName(name)
				  .done();
	}

	public static FileVersion parseFileVersion(Node node, String elementId, String fileId) {
		String version 	 = ReaderUtil.getAttributeValue(node, "Version");
		String kbSize  	 = ReaderUtil.getAttributeValue(node, "KbSize");
		String created 	 = ReaderUtil.getAttributeValue(node, "Created");
		String creatorId = ReaderUtil.getAttributeValue(node, "CreatorId");
		String note 	 = ReaderUtil.getAttributeValue(node, "Note");
		
		return FileVersion.newBuilder()
						.withElementId(elementId)
						.withFileId(fileId)
						.withVersion(Integer.parseInt(version))
						.withKbSize(Integer.parseInt(kbSize))
						.withCreatedDate(ReaderUtil.parseDate(created))
						.withCreatorId(creatorId)
						.withNote(note)
						.done();
		
	}

	public static Message parseMessage(Node messageNode) {
		String authorUserId = ReaderUtil.getAttributeValue(messageNode, "AuthorUserId");
		String body 	    = ReaderUtil.getAttributeValue(messageNode, "Body");
		String elementId    = ReaderUtil.getAttributeValue(messageNode, "ElementId");
		String subject      = ReaderUtil.getAttributeValue(messageNode, "Subject");
		String updated 		= ReaderUtil.getAttributeValue(messageNode, "Updated");
		
		return Message.newBuilder()
					.withAuthorUserId(authorUserId)
					.withBody(body)
					.withElementId(elementId)
					.withSubject(subject)
					.withUpdated(ReaderUtil.parseDate(updated))
					.done();
	}

	public static Poll parsePoll(Node pollNode) {
		String pollId 				= ReaderUtil.getAttributeValue(pollNode, "Id");
		String question 			= ReaderUtil.getAttributeValue(pollNode, "Question");
		String authorUserId 		= ReaderUtil.getAttributeValue(pollNode, "AuthorUserId");
		String elementId 			= ReaderUtil.getAttributeValue(pollNode, "ElementId");
		String created 				= ReaderUtil.getAttributeValue(pollNode, "Created");
		String isActive 			= ReaderUtil.getAttributeValue(pollNode, "IsActive");
		String resultsVisibility	= ReaderUtil.getAttributeValue(pollNode, "ResultsVisibility");
		String closing 				= ReaderUtil.getAttributeValue(pollNode, "Closing");
		String currentUserHasVoted 	= ReaderUtil.getAttributeValue(pollNode, "CurrentUserHasVoted");
		String currentUserCanVote 	= ReaderUtil.getAttributeValue(pollNode, "CurrentUserCanVote");
		String type 				= ReaderUtil.getAttributeValue(pollNode, "Type");
		
		Element element				 = parseElement(ReaderUtil.getChildNodeByName(pollNode, "Element"));
		UserInfo userInfo 			 = parseUserInfo(ReaderUtil.getChildNodeByName(pollNode, "User"));
		List<PollOption> pollOptions = parsePollOptions(ReaderUtil.getChildNodeByName(pollNode, "Options"));
		
		
		return Poll.newBuilder()
					.withPollId(pollId)
					.withQuestion(question)
					.withAuthorUserId(authorUserId)
					.withElementId(elementId)
					.withCreated(ReaderUtil.parseDate(created))
					.withIsActive(Boolean.valueOf(isActive))
					.withResultsVisibility(resultsVisibility)
					.withClosing(ReaderUtil.parseDate(closing))
					.withCurrentUserCanVote(Boolean.valueOf(currentUserCanVote))
					.withCurrentUserHasVoted(Boolean.valueOf(currentUserHasVoted))
					.withType(type)
					.withElement(element)
					.withUserInfo(userInfo)
					.withPollOptions(pollOptions)
					.done();
	}

	public static UserInfo parseUserInfo(Node userInfoNode) {
		String givenName 		 = ReaderUtil.getAttributeValue(userInfoNode, "GivenName");
		String familyName 		 = ReaderUtil.getAttributeValue(userInfoNode, "FamilyName");
		String closed 			 = ReaderUtil.getAttributeValue(userInfoNode, "Closed");
		String email  			 = ReaderUtil.getAttributeValue(userInfoNode, "Email");
		String preferredLanguage = ReaderUtil.getAttributeValue(userInfoNode, "PreferredLanguage");
		String userId	 		 = ReaderUtil.getAttributeValue(userInfoNode, "UserId");
	
		return UserInfo.newBuilder()
				.withGivenName(givenName)
				.withFamilyName(familyName)
				.withClosed(Boolean.valueOf(closed))
				.withEmail(email)
				.withPreferredLanguage(preferredLanguage)
				.withUserId(userId)
				.done();
	}

	public static List<PollOption> parsePollOptions(Node pollOptionsNode) {
		NodeList pollOptionNodes = pollOptionsNode.getChildNodes();
		List<PollOption> pollOptions = Lists.newArrayList();
		for(int i = 0; i < pollOptionNodes.getLength(); ++i) {
			Node pollOptionNode = pollOptionNodes.item(i);
			pollOptions.add(parsePollOption(pollOptionNode));
		}
		return pollOptions;
	}
	
	public static PollOption parsePollOption(Node pollOptionNode) {
		String id 						 = ReaderUtil.getAttributeValue(pollOptionNode, "Id");
		String text 					 = ReaderUtil.getAttributeValue(pollOptionNode, "Text");
		String currentUserHasVotedOnThis = ReaderUtil.getAttributeValue(pollOptionNode, "CurrentUserVotedOnThis");
		
		return PollOption.newBuilder()
						.withId(id)
						.withText(text)
						.withCurrentUserHasVotedOnThis(Boolean.valueOf(currentUserHasVotedOnThis))
						.done();
	}

	public static Cafeteria parseCafeteria(Node cafeteriaNode) {
		String id = ReaderUtil.getAttributeValue(cafeteriaNode, "Id");
		String link = ReaderUtil.getAttributeValue(cafeteriaNode, "Link");
		String name = ReaderUtil.getAttributeValue(cafeteriaNode, "Name");
		
		List<Menus> dailyMenus = Lists.newArrayList();
		for(int i = 0; i < cafeteriaNode.getChildNodes().getLength(); ++i) {
			Node menusNode = cafeteriaNode.getChildNodes().item(i);
			dailyMenus.add(parseMenus(menusNode));
		}
		
		return Cafeteria.newBuilder()
					.withId(id)
					.withName(name)
					.withLink(link)
					.withDailyMenus(dailyMenus)
					.done();
	}
	
	public static Menus parseMenus(Node menusNode) {
		String startDate = ReaderUtil.getAttributeValue(menusNode, "Date");
		String endDate   = ReaderUtil.getAttributeValue(menusNode, "EndDate");
		
		List<Menu> menus = Lists.newArrayList();
		for(int i = 0; i < menusNode.getChildNodes().getLength(); ++i) {
			Node menuNode = menusNode.getChildNodes().item(i);
			menus.add(parseMenu(menuNode));
		}
		
		return Menus.newBuilder()
				.withEndDate(ReaderUtil.parseDate(endDate))
				.withStartDate(ReaderUtil.parseDate(startDate))
				.withMenus(menus)
				.done();
	}
	
	public static Menu parseMenu(Node menuNode) {
		String price = ReaderUtil.getAttributeValue(menuNode, "Price");
		String title = ReaderUtil.getAttributeValue(menuNode, "Title");
		String text  = ReaderUtil.getAttributeValue(menuNode, "Text");
		
		return Menu.newBuilder()
				.withPrice(price)
				.withText(text)
				.withTitle(title)
				.done();		
	}
	
	// TODO: Find better solution instead of random accessing.
	public static EducationProgramme parseEducationProgramme(Node educationProgrammeNode) {
		String displayName = ReaderUtil.getAttributeValue(educationProgrammeNode, "DisplayName");
		String active      = ReaderUtil.getAttributeValue(educationProgrammeNode, "Active");
		
		PassedECTSSum passedECTSSum = parsePassedECTSSum(educationProgrammeNode.getChildNodes().item(0));
		
		NodeList examResultNodes = educationProgrammeNode.getChildNodes().item(1)
														 .getChildNodes();
		List<ExamResult> examResults = Lists.newArrayList();
		for(int i = 0; i < examResultNodes.getLength(); ++i) {
			Node examResultNode = examResultNodes.item(i);
			examResults.add(parseExamResult(examResultNode));
		}
		
		NodeList creditResultNodes = educationProgrammeNode.getChildNodes().item(2)
														   .getChildNodes();
		List<CreditResult> creditResults = Lists.newArrayList();
		for(int i = 0; i < creditResultNodes.getLength(); ++i) {
			Node creditResultNode = creditResultNodes.item(i);
			creditResults.add(parseCreditResult(creditResultNode));
		}
		
		return EducationProgramme.newBuilder()
							.withDisplayName(displayName)
							.withActive(Boolean.valueOf(active))
							.withPassedECTSSum(passedECTSSum)
							.withExamResults(examResults)
							.withCreditResults(creditResults)
							.done();
	}
	
	public static PassedECTSSum parsePassedECTSSum(Node passedECTSSumNode) {
		String ectsFromExams 	= ReaderUtil.getAttributeValue(passedECTSSumNode, "Exams");
		String ectsFromCredits 	= ReaderUtil.getAttributeValue(passedECTSSumNode, "Credits");
		String ectsTotal  		= ReaderUtil.getAttributeValue(passedECTSSumNode, "Total");
	
		return PassedECTSSum.newBuilder()
						.withECTSFromCredits(Float.parseFloat(ectsFromCredits))
						.withECTSFromExams(Float.parseFloat(ectsFromExams))
						.withECTSTotal(Float.parseFloat(ectsTotal))
						.done();
	}

	public static ExamResult parseExamResult(Node examResultNode) {
		String courseCode 	= ReaderUtil.getAttributeValue(examResultNode, "CourseCode");
		String ectsGiven 	= ReaderUtil.getAttributeValue(examResultNode, "EctsGiven");
		String ectsPoints 	= ReaderUtil.getAttributeValue(examResultNode, "EctsPoints");
		String grade 		= ReaderUtil.getAttributeValue(examResultNode, "Grade");
		String period 		= ReaderUtil.getAttributeValue(examResultNode, "Period");
		String year 		= ReaderUtil.getAttributeValue(examResultNode, "Year");
		String name		 	= ReaderUtil.getAttributeValue(examResultNode, "Name");
		
		return ExamResult.newBuilder()
						.withCourseCode(courseCode)
						.withECTSGiven(Boolean.valueOf(ectsGiven))
						.withECTSPoints(Float.valueOf(ectsPoints))
						.withGrade(grade)
						.withPeriod(period)
						.withYear(Integer.parseInt(year))
						.withCourseName(name)
						.done();
	}

	public static CreditResult parseCreditResult(Node creditResultNode) {
		String ectsGiven 	= ReaderUtil.getAttributeValue(creditResultNode, "EctsGiven");
		String ectsPoints 	= ReaderUtil.getAttributeValue(creditResultNode, "EctsPoints");
		String grade 		= ReaderUtil.getAttributeValue(creditResultNode, "Grade");
		String date 		= ReaderUtil.getAttributeValue(creditResultNode, "Date");
		String name 		= ReaderUtil.getAttributeValue(creditResultNode, "Name");
		
		return CreditResult.newBuilder()
						.withDate(ReaderUtil.parseDate(date))
						.withECTSGiven(Boolean.valueOf(ectsGiven))
						.withECTSPoints(Float.valueOf(ectsPoints))
						.withGrade(grade)
						.withName(name)
						.done();
	}
}
