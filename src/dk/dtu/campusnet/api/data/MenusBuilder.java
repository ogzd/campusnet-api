package dk.dtu.campusnet.api.data;

import java.util.Date;
import java.util.List;

public class MenusBuilder {
	
	private Menus menus;
	
	protected MenusBuilder() {
		menus = new Menus();
	}
	
	public MenusBuilder withStartDate(Date startDate) {
		menus.setStartDate(startDate);
		return this;
	}
	
	public MenusBuilder withEndDate(Date endDate) {
		menus.setEndDate(endDate);
		return this;
	}
	
	public MenusBuilder withMenus(List<Menu> dailyMenus) {
		menus.setMenus(dailyMenus);
		return this;
	}
	
	public Menus done() {
		return menus;
	}

}
