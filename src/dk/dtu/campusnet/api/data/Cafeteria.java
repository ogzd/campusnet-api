package dk.dtu.campusnet.api.data;

import java.util.List;

public class Cafeteria {

	private String id;
	private String name;
	private String link;
	private List<Menus> dailyMenus;
	
	protected Cafeteria() {
		
	}
	
	public static CafeteriaBuilder newBuilder() {
		return new CafeteriaBuilder();
	}
	
	protected void setId(String id) {
		this.id = id;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setLink(String link) {
		this.link = link;
	}
	
	protected void setDailyMenus(List<Menus> dailyMenus) {
		this.dailyMenus = dailyMenus;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLink() {
		return link;
	}
	
	public List<Menus> getDailyMenus() {
		return dailyMenus;
	}
}
