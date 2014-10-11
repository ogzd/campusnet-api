package dk.dtu.campusnet.api.data;

import java.util.Date;
import java.util.List;

public class Menus {

	private Date startDate;
	private Date endDate;
	private List<Menu> menus;

	protected Menus() {
		
	}
	
	public static MenusBuilder newBuilder() {
		return new MenusBuilder();
	}
	
	protected void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	protected void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	protected void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public List<Menu> getMenus() {
		return menus;
	}
}
