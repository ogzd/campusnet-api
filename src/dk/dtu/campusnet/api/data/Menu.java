package dk.dtu.campusnet.api.data;

public class Menu {

	private String price;
	private String title;
	private String text;
	
	protected Menu() {
		
	}
	
	public static MenuBuilder newBuilder() {
		return new MenuBuilder();
	}
	
	protected void setPrice(String price) {
		this.price = price;
	}
	
	protected void setTitle(String title) {
		this.title = title;
	}
	
	protected void setText(String text) {
		this.text = text;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getText() {
		return text;
	}
	
}
