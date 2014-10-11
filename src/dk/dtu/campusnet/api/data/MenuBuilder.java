package dk.dtu.campusnet.api.data;

public class MenuBuilder {

	private Menu menu;
	
	protected MenuBuilder() {
		menu = new Menu();
	}
	
	public MenuBuilder withPrice(String price) {
		menu.setPrice(price);
		return this;
	}
	
	public MenuBuilder withText(String text) {
		menu.setText(text);
		return this;
	}
	
	public MenuBuilder withTitle(String title) {
		menu.setTitle(title);
		return this;
	}
	
	public Menu done() {
		return menu;
	}
}
