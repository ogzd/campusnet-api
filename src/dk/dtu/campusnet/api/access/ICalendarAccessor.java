package dk.dtu.campusnet.api.access;

import java.util.Date;
import java.util.List;

import dk.dtu.campusnet.api.data.Appointment;
import dk.dtu.campusnet.api.data.FeedInfo;

public interface ICalendarAccessor {
	
	/**
	 * Returns amount next calendar appointments from integrated groups, starting from first.
	 * @param first
	 * @param amount
	 * @return
	 */
	public List<Appointment> getUpcomingAppointments(int first, int amount);
	
	/**
	 * Returns calendar appointments that start on a date between startDate and endDate, inclusive. 
	 * Personal appointments and appointments from integrated groups are both included.
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Appointment> getAppointments(Date startDate, Date endDate);
	
	/**
	 * Returns info about your personal calendar feed. It includes appointments from all your groups that have 
	 * public content and from your personal calendar.
	 * @return
	 */
	public FeedInfo getFeedInfo();

}
