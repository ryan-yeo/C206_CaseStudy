
public class MenuItem {

	private String category;
	private String name;
	private float price;
	
	public MenuItem(String category, String itemName, float price) {
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
	public String getItemName() {
		return name;
	}
	public void setItemName() {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice() {
		this.price = price;
	}

	public void setItemName(String itemName) {
		this.name = itemName;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
