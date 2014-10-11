package dk.dtu.campusnet.api.data;

import java.util.Date;

public class AppointmentBuilder {

	private Appointment appointment;
	
	protected AppointmentBuilder() {
		appointment = new Appointment();
	}
	
	public AppointmentBuilder withTitle(String title) {
		appointment.setTitle(title);
		return this;
	}
	
	public AppointmentBuilder withUpdatedDate(Date updatedDate) {
		appointment.setUpdatedDate(updatedDate);
		return this;
	}
	
	public AppointmentBuilder withStartDate(Date startDate) {
		appointment.setStartDate(startDate);
		return this;
	}
	
	public AppointmentBuilder withEndDate(Date endDate) {
		appointment.setEndDate(endDate);
		return this;
	}
	
	public AppointmentBuilder withContent(String content) {
		appointment.setContent(content);
		return this;
	}
	
	public AppointmentBuilder withLink(String link) {
		appointment.setLink(link);
		return this;
	}
	
	public AppointmentBuilder withName(String name) {
		appointment.setName(name);
		return this;
	}
	
	public AppointmentBuilder withHref(String href) {
		appointment.setHref(href);
		return this;
	}
	
	public Appointment done() {
		return appointment;
	}
	
}
