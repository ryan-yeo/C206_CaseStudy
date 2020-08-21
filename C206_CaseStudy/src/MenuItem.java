
public class MenuItem {

	private String category;
	private String name;
	private double price;
	
	public MenuItem(String category, String itemName, double price) {
		this.category = category;
		this.name = itemName;
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
