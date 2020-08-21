import java.util.ArrayList;

// By Vanessa
public class Order {
	
	private String username;
	private String status;
	private boolean takeaway;
	private ArrayList<MenuItem> items;
	
	public Order(String username, String status, boolean takeaway, ArrayList<MenuItem> items) {
		this.username = username;
		this.status = status;
		this.takeaway = takeaway;
		this.items = items;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isTakeaway() {
		return takeaway;
	}

	public void setTakeaway(boolean takeaway) {
		this.takeaway = takeaway;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
	public String toString() {

		String itemList = "";
		for (int i=0; i < items.size(); i++) {
			itemList += items.get(i).getItemName();
			if (i != (items.size()-1)) {
				itemList += ", ";
			}
		}
		
		String output = String.format("%-15s %-15s %-15b %s\n", username, status, takeaway, itemList);
		return output;
		
	}
}
