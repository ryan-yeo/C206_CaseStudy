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
		
		ArrayList<Order> OrderList1 = new ArrayList<Order>();
		assertEquals("Check arrayList size is 0", 0, OrderList1.size());
		
		String output ="";
		for (Order i : OrderList) {
			output += i.toString();
		}
		String testOutput = String.format("%-15s %-15s %-15b %s\n", "Vanny", "Processing", true, "Chicken Chop");
		
		assertEquals("Check that ViewAllOrder", testOutput, output);
	}
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
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		promotionList.add(new Promotion("1-1 ICE MILO", "2020-08-22", 1));
		
		boolean check = false;
		if (promotionList.get(0).getPromotionCode().equalsIgnoreCase("1-1 ICE MILO") && promotionList.get(0).getEndDate().equalsIgnoreCase("2020-08-22")) {
			promotionList.remove(0);
			check = true;
		}
		assertTrue(check);
	}
// NICOLE Promotion Test END
	@After
	public void tearDown() throws Exception {
		promo1 = null;
		Promo2 = null;
		promotionList = null;
	}
}
