import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CanteenAppTest {
	private Promotion promo1;
	private Promotion Promo2;
	private ArrayList<Promotion> promotionList;
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		promo1 = new Promotion("1-1 ICE MILO", "2020-8-22", 1);
		Promo2 = new Promotion("1-1 cheese fries", "2020-8-23", 1.50);
		promotionList = new ArrayList<Promotion>();
	}
	
	
	
// Start - Vanessa (Order)
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
		
		// Pre-Order
		ArrayList<MenuItem> xxx = new ArrayList<MenuItem>();
		xxx.add(new MenuItem("Western", "Fish n' Chips", 8.90));
		xxx.add(new MenuItem("Western", "Chicken Chop", 5.90));
		Order order = new Order("Bubbling", "Processing", true, true, "29-08-2020 23:59", xxx);
		OrderList.add(order);
		assertSame("Check that Pre-Order is added", order, OrderList.get(1));
		assertEquals("Check arrayList size is 2", 2, OrderList.size());
	}
	
	@Test
	public void updateOrderStatus() {
		ArrayList<Order> OrderList = new ArrayList<Order>();
		ArrayList<MenuItem> xxx = new ArrayList<MenuItem>();
		xxx.add(new MenuItem("Western", "Fish n' Chips", 8.90));
		xxx.add(new MenuItem("Western", "Chicken Chop", 5.90));
		Order order = new Order("Bubbling", "Processing", true, true, "29-08-2020 23:59", xxx);
		OrderList.add(order);
		
		// Update Part
		OrderList.get(0).setStatus("Completed");
		assertEquals("Check Order status is update > ", "Completed", OrderList.get(0).getStatus());
		
	}
	
	@Test
	public void updateOrderTakeaway() {
		ArrayList<Order> OrderList = new ArrayList<Order>();
		ArrayList<MenuItem> xxx = new ArrayList<MenuItem>();
		xxx.add(new MenuItem("Western", "Fish n' Chips", 8.90));
		xxx.add(new MenuItem("Western", "Chicken Chop", 5.90));
		Order order = new Order("Bubbling", "Processing", true, true, "29-08-2020 23:59", xxx);
		OrderList.add(order);
		
		// Update Part
		OrderList.get(0).setTakeaway(false);
		assertEquals("Check Order takeaway flag is update > ", false, OrderList.get(0).isTakeaway());
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
		
		ArrayList<Order> OrderList1 = new ArrayList<Order>();
		assertEquals("Check arrayList size is 0", 0, OrderList1.size());
		
		String output ="";
		for (Order i : OrderList) {
			output += i.toString();
		}

		String testOutput = String.format("%-15s %-13s %-10b %-13b %-25s %s\n", "Vanny", "Processing", true, false, null, "Chicken Chop");
		
		assertEquals("Check that ViewAllOrder", testOutput, output);
	}

// End - Order
	
//---------------------------------------------------------------------------
	
// NICOLE Promotion TEST
	@Test
	public void addPromotionTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Promotion arraylist to add to", promotionList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		CanteenApp.addPromotion(promotionList, promo1);
		assertEquals("Check that Promotion arraylist size is 1", 1, promotionList.size());
		assertSame("Check that Camcorder is added", promo1, promotionList.get(0));
	}
	@Test
	public void viewPromotionTest() {
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Chromebook arraylist to retrieve item from", promotionList);
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		CanteenApp.addPromotion(promotionList, promo1);
		CanteenApp.addPromotion(promotionList, Promo2);
		assertEquals("Test that Promotion arraylist size is 2", 2, promotionList.size());
	}
	@Test
	public void deletePromotionTest() {
		// normal
		Boolean ok = CanteenApp.doDeletePromotion(promotionList, "1-1 ICE MILO", "2020-8-22");
		assertTrue("Test if item is ok to delete?", ok);
		//error condition
		ok = CanteenApp.doDeletePromotion(promotionList, "1-1 ICE MILO", "2020-8-22");
		assertFalse("Test if same item is NOT ok to deletes again?", ok);	
	}
// NICOLE Promotion Test END
	
	@After
	public void tearDown() throws Exception {
		promo1 = null;
		Promo2 = null;
		promotionList = null;
	}
}
