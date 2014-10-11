package dk.dtu.campusnet.api.data;

import java.util.Date;

public class Appointment {

	private String title;
	private Date updatedDate;
	private Date startDate;
	private Date endDate;
	private String content;
	private String link;
	private String name;
	private String href;
	
	protected Appointment() {
		
	}
	
	public static AppointmentBuilder newBuilder() {
		return new AppointmentBuilder();
	}
	
	protected void setTitle(String title) {
		this.title = title;
	}

	protected void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	protected void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	protected void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	protected void setContent(String content) {
		this.content = content;
	}

	protected void setLink(String link) {
		this.link = link;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setHref(String href) {
		this.href = href;
	}

	public String getTitle() {
		return title;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getContent() {
		return content;
	}

	public String getLink() {
		return link;
	}

	public String getName() {
		return name;
	}

	public String getHref() {
		return href;
	}
	
	
}
