import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

public class CanteenAppTest {
	
	@Test
	public void addOrderTesting() {
		ArrayList<MenuItem> xx = new ArrayList<MenuItem>();
		xx.add(new MenuItem("Western", "Fish n' Chips", 8.90));
		
		ArrayList<Order> OrderList = new ArrayList<Order>();
		OrderList.add(new Order("Vanny", "Processing", true, xx));
		
		assertEquals("Check ArrayList size is 1", 1, OrderList.size());
		assertEquals("Check Username is Vanny", "Vanny", OrderList.get(0).getUsername());
		assertEquals("Check Status is processing", "Processing", OrderList.get(0).getStatus());
		assertEquals("Check Takeaway is true", true, OrderList.get(0).isTakeaway());
		assertEquals("Check Menu category is Western", "Western", OrderList.get(0).getItems().get(0).getCategory());
		assertEquals("Check food item is Fish n' Chips", "Fish n' Chips", OrderList.get(0).getItems().get(0).getName());
		
		boolean check = false;
		if (OrderList.get(0).getItems().get(0).getPrice() == 8.9) {
			check = true;
		} else {
			check = false;
		}
		assertTrue(check);
	}
	
	@Test
	public void deleteOrder() {
		ArrayList<MenuItem> xx = new ArrayList<MenuItem>();
		xx.add(new MenuItem("Western", "Fish n' Chips", 8.90));
		
		ArrayList<Order> OrderList = new ArrayList<Order>();
		OrderList.add(new Order("Vanny", "Processing", true, xx));
		
		boolean check = false;
		if (OrderList.get(0).getUsername().equalsIgnoreCase("vanny")) {
			OrderList.remove(0);
			check = true;
		}
		assertTrue(check);
	}
	
	@Test
	public void viewAllOrder() {
		ArrayList<MenuItem> xx = new ArrayList<MenuItem>();
		xx.add(new MenuItem("Western", "Chicken Chop", 5.90));
		ArrayList<Order> OrderList = new ArrayList<Order>();
		OrderList.add(new Order("Vanny", "Processing", true, xx));
		
		assertEquals("Check arrayList size is 1", 1, OrderList.size());
		
		String output ="";
		for (Order i : OrderList) {
			output += i.toString();
		}
		String testOutput = String.format("%-15s %-15s %-15b %s\n", "Vanny", "Processing", true, "Chicken Chop");
		
		assertEquals("Check that ViewAllOrder", testOutput, output);
	}
	
}
