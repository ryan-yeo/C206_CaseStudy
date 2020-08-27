import java.util.ArrayList;

// By Vanessa
public class Order {
	
	private String username;
	private String status;
	private boolean takeaway;
	private ArrayList<MenuItem> items;
	
	private boolean preOrder;
	private String collectionDate;
	
	public Order(String username, String status, boolean takeaway, ArrayList<MenuItem> items) {
		this.username = username;
		this.status = status;
		this.takeaway = takeaway;
		this.items = items;
		this.preOrder = false;
		this.collectionDate = null;
	}
	
	public Order(String username, String status, boolean takeaway, boolean preOrder,
			String collectionDate, ArrayList<MenuItem> items) {
		this.username = username;
		this.status = status;
		this.takeaway = takeaway;
		this.items = items;
		this.preOrder = preOrder;
		this.collectionDate = collectionDate;
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
	
	public boolean isPreOrder() {
		return preOrder;
	}

	public void setPreOrder(boolean preOrder) {
		this.preOrder = preOrder;
	}

	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String toString() {

		String itemList = "";
		for (int i=0; i < items.size(); i++) {
			itemList += items.get(i).getName();
			if (i != (items.size()-1)) {
				itemList += ", ";
			}
		}
		
		String output = String.format("%-15s %-13s %-10b %-13b %-25s %s\n", username, status, takeaway, preOrder, collectionDate, itemList);
		return output;
		
	}
}
