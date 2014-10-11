package dk.dtu.campusnet.api.access;

import java.util.Date;
import java.util.List;

import org.w3c.dom.Document;

import dk.dtu.campusnet.api.data.Appointment;
import dk.dtu.campusnet.api.data.FeedInfo;
import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.CalendarReader;
import dk.dtu.campusnet.api.reader.FeedInfoReader;
import dk.dtu.campusnet.api.reader.Reader;
import dk.dtu.campusnet.api.reader.ReaderUtil;

public class ElementCalendarAccessor implements ICalendarAccessor {

	private final String elementId;
	
	public ElementCalendarAccessor(String elementId) {
		this.elementId = elementId;
	}
	
	@Override
	public List<Appointment> getUpcomingAppointments(int first, int amount) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Calendar/Upcoming/From/%s/Returning/%s", 
									elementId, first, amount));
		return Reader.load(CalendarReader.class, doc)
				     .getAppointments();
	}

	@Override
	public List<Appointment> getAppointments(Date startDate, Date endDate) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Calendar/%s/To/%s", 
									elementId,
									ReaderUtil.toString(startDate),
									ReaderUtil.toString(endDate)));
		return Reader.load(CalendarReader.class, doc)
				     .getAppointments();
	}

	@Override
	public FeedInfo getFeedInfo() {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Calendar/FeedInfo",
									elementId));
		return Reader.load(FeedInfoReader.class, doc)
					 .getFeedInfo();
	}
}
