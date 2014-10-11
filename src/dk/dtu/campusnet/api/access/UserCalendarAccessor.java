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

public class UserCalendarAccessor implements ICalendarAccessor {

	@Override
	public List<Appointment> getUpcomingAppointments(int first, int amount) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Calendar/Upcoming/From/%s/Returning/%s", 
				first, amount));
		return Reader.load(CalendarReader.class, doc)
					 .getAppointments();
	}

	@Override
	public List<Appointment> getAppointments(Date startDate, Date endDate) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Calendar/%s/To/%s", 
				ReaderUtil.toString(startDate),
				ReaderUtil.toString(endDate)));
		return Reader.load(CalendarReader.class, doc)
					 .getAppointments();
	}

	@Override
	public FeedInfo getFeedInfo() {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Calendar/FeedInfo"));
		
		return Reader.load(FeedInfoReader.class, doc)
					 .getFeedInfo();
	}

	/**
	 * Performs a search among calendar entries in all your active groups in the CampusNet database using 
     * query as the search string. The search algorithm supports double quotes for exact matches and the 
     * exclusion operator “-“. Results are sorted based on ranking, not based on dates.
     * The parameters first and amount control which portion of the search results are shown. These are 
     * optional and default to 1 and 20, respectively. The maximum value for both values is 100.
     * If more parameters are added to the specification at some point, they will be optional as well.
	 * @param query
	 * @param first
	 * @param amount
	 * @return
	 */
	public List<Appointment> search(String query, int first, int amount) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Calendar/Search?query=%s&first=%s&amount=%s", 
				query, first, amount));
		return Reader.load(CalendarReader.class, doc)
					 .getAppointments();
	}

}
