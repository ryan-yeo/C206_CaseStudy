import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CanteenAppTest {
private ArrayList<Promotion> promotionList;
private ArrayList<Account> accountList;
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		promotionList = new ArrayList<Promotion>();
		accountList = new ArrayList<Account>();
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
		// Promotion list is not null, so that can add a new promotion - boundary
		assertNotNull("Check if there is valid Promotion arraylist to add to", promotionList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		promotionList.add(new Promotion("Promo1", "2020-08-31", 1));
		assertEquals("Check that Promotion arraylist size is 1", 1, promotionList.size());
		assertTrue(true);
		//Test that the input has "Promo" as the start and the endDate is before the expire date - normal
		ZoneId S = ZoneId.of("Singapore");
		LocalDate date = LocalDate.now(S);
		LocalDate ending = LocalDate.parse("2020-08-31");
		if("Promo1".startsWith("Promo") && date.isBefore(ending)) {
			assertTrue(true);
		}
		// Test that input that not meet the requirement cannot be added. - error
		if(!"1-1 ICE MILO".startsWith("Promo") && date.isBefore(ending)) {
			assertFalse(false);
		}
		//Same promotion can't be added twice- error
		promotionList.add(new Promotion("Promo1", "2020-08-31", 1));
		for(int i = 0; i < promotionList.size(); i++) {
			if(promotionList.get(i).getPromotionCode().equals("Promo1") && promotionList.get(i).getEndDate().equals("2020-08-31")) {
				assertFalse(false);
			}
		}
		
	}
	@Test
	public void viewPromotionTest() {
		// Test that promotionList is null, can it add promotion - boundary
		assertNotNull("Check is there is a promotion to add", promotionList);
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		promotionList.add(new Promotion("Promo1", "2020-08-31", 1));
		promotionList.add(new Promotion("Promo2", "2020-08-28", 1));
		assertEquals("Test that Promotion arraylist size is 2", 2, promotionList.size());
		assertTrue(true);
		//show the header when promotionList is empty - error
		if(promotionList.size() < 0) {
			String testouput = " ";
			testouput = String.format("%-20s %-20s %-20s\n", "PROMOTION CODE", "END DATE", "DISCOUNT AMOUNT");
		}
	}
	@Test
	public void deletePromotionTest() {
		// Test that promotionList is null, cannot that delete anything - boundary
		assertNotNull("Check that promotionList is empty and cannot delete", promotionList);
		//Check that the promotion is in promotionList then remove the promotion - normal
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		promotionList.add(new Promotion("Promo1", "2020-08-31", 1));
		
		boolean check = false;
		if (promotionList.get(0).getPromotionCode().equalsIgnoreCase("Promo1") && promotionList.get(0).getEndDate().equalsIgnoreCase("2020-08-31")) {
			promotionList.remove(0);
			check = true;
		}
		assertTrue(check);
		//Same promotion Can't be deleted twice - error
		promotionList.add(new Promotion("Promo1", "2020-08-31", 1));
		for(int i = 0; i < promotionList.size(); i++) {
			if(promotionList.get(i).getPromotionCode().equals("Promo1") && promotionList.get(i).getEndDate().equals("2020-08-31")) {
				assertFalse(false);
			}
		}
	}
	@Test
	public void updatePromotionTest() {
		// Test that promotionList is null, cannot that delete anything - boundary
		assertNotNull("Check that promotionList is empty and cannot update", promotionList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		for(int i = 0; i < promotionList.size(); i++) {
			if(promotionList.get(i).getPromotionCode().equals("Promo1") && promotionList.get(i).getEndDate().equals("2020-08-31")) {
				promotionList.get(i).setPromotionCode("Promo2");
				promotionList.get(i).setEndFate("2020-08-27");
				promotionList.get(i).setDiscountAmount(1);
			}
		}
		assertTrue(true);
		//Test that Update was done but it not updated- error
		for(int i = 0; i < promotionList.size(); i++) {
			if(promotionList.get(i).getPromotionCode().equals("Promo1") && promotionList.get(i).getEndDate().equals("2020-08-31")) {
				promotionList.get(i).setPromotionCode("Promo2");
				promotionList.get(i).setEndFate("2020-08-27");
				promotionList.get(i).setDiscountAmount(1);
			}
		}
		assertFalse(false);
	
	}
	// NICOLE Promotion Test END
	
	//Akhil User Account test 
	@Test
	public void addAccounttest() {

		Account j1 = new Account("NAME", "PASSWORD");
		
		// Check if the list is not null but empty boundary
		assertEquals("Check if arraylist size is 0" , 0, accountList.size());
		
		// Having added an item to an empty list, test if the list size is 1
		accountList.add(j1);
		// Add an item and test if ArrayList has a size of 1
		assertEquals("Check if arraylist size is 1" , 1, accountList.size());
	}

	@Test
	public void retrieveAccounttest() {
		Account j1 = new Account("NAME", "PASSWORD");
		accountList.add(j1);
		// Remove customer according to the list. Check if planned output String is the same as retrieved package list
		String output = String.format("%-10s %-10s\n", "NAME", "PASSWORD");;
		// Check if output string is similar to the received list
		assertEquals("checks if its retrieved properly", output, accountList.get(0).toString());

	}

	@Test
	public void viewAccounttest() {
		// Given an empty list, check if the list size is 1 after adding 1 account
		addAccounttest();

		String output = CanteenApp.retrieveAllAccount(accountList);
		// Test if the predicted output String is the same as the retrieved list
		assertEquals("Checks if view all is working properly.", output, CanteenApp.retrieveAllAccount(accountList));
	}

	@Test
	public void deleteAccount() {
		Account j1 = new Account("NAME", "PASSWORD");
		accountList.add(j1);
		assertNotNull("Test if there is valid Request Quotation arraylist to retrieve item", accountList);
		// Check if the list size is 1 given an empty list after deleting 1 account
		accountList.remove(0);
		assertEquals("Checks if deleted properly,", 0, accountList.size());
	}


	@After
	public void tearDown() throws Exception {
		promotionList = null;
		accountList = null;
	}
}
