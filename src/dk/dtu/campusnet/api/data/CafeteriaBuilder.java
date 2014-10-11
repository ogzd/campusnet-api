package dk.dtu.campusnet.api.data;

import java.util.List;

public class CafeteriaBuilder {

	private Cafeteria cafeteria;
	
	protected CafeteriaBuilder() {
		
	}
	
	public CafeteriaBuilder withId(String id) {
		cafeteria.setId(id);
		return this;
	}
	
	public CafeteriaBuilder withName(String name) {
		cafeteria.setName(name);
		return this;
	}
	
	public CafeteriaBuilder withLink(String link) {
		cafeteria.setLink(link);
		return this;
	}
	
	public CafeteriaBuilder withDailyMenus(List<Menus> dailyMenus) {
		cafeteria.setDailyMenus(dailyMenus);
		return this;
	}
	
	public Cafeteria done() {
		return cafeteria;
	}
	
}
