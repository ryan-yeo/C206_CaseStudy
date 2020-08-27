import java.util.ArrayList;
import java.time.LocalDate;
import java.time.ZoneId;

public class CanteenApp {

	// Start - By Vanessa:
	private static ArrayList<Order> OrderList = new ArrayList<Order>();
	// End

	// Start - sajnam
	private static ArrayList<PurchaseOrder> purchaseList = new ArrayList<PurchaseOrder>();
	// end

	// -----RyanStart-----\\
	private static ArrayList<MenuItem> MenuList = new ArrayList<MenuItem>();
	// -----RyanEnd-----\\

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// -----RyanStart-----\\


		// -----RyanStart-----\\

		MenuList.add(new MenuItem("Indian", "Prata", 4.99));
		MenuList.add(new MenuItem("Middle East", "Kebab", 6.99));
		MenuList.add(new MenuItem("Western", "Chicken Chop", 5.90));
		MenuList.add(new MenuItem("Western", "Fish n' Chips", 8.90));
		MenuList.add(new MenuItem("Local", "Fried Rice", 5.0));


		// -----RyanEnd-----\\

		// Start - By Vanessa:
		int option = 0;
		ArrayList<MenuItem> xx = new ArrayList<MenuItem>();
		ArrayList<MenuItem> xxx = new ArrayList<MenuItem>();
		xx.add(new MenuItem("Western", "Chicken Chop", 5.90));
		xx.add(new MenuItem("Western", "Fish n' Chips", 8.90));
		xxx.add(new MenuItem("Local", "Fried Rice", 5.0));
		OrderList.add(new Order("Vanny", "Processing", true, xx));
		OrderList.add(new Order("Bubbling", "Processing", true, xxx));
		// End

		// Start by NICOLE
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		// End

		// By Vanessa:
		while (option != 6) {
			CanteenApp.optionMenu();
			option = Helper.readInt("Enter option > ");
			System.out.println("");

			switch (option) {

			case 1: // User Account

				CanteenApp.setHeader("USER ACCOUNT MENU");
				System.out.println("1. VIEW USER ACCOUNT");
				System.out.println("2. CREATE USER ACCOUNT");
				System.out.println("3. DELETE USER ACCOUNT");
				int choice = Helper.readInt("Enter choice > ");

			case 1: // User Account -> Akhil

				CanteenApp.setHeader("USER ACCOUNT MENU");
				System.out.println("1. VIEW USER ACCOUNT");
				System.out.println("2. CREATE USER ACCOUNT");
				System.out.println("3. DELETE USER ACCOUNT");
				int choice = Helper.readInt("Enter choice > ");

				ArrayList<Account> accountList;
				if (choice == 1) {
//						CanteenApp.viewAllAccounts(accountList);
				} else if (choice == 2) {
//						Account acc = new Account(userAccount, accountPassword);
//						accountList.add(acc);
					System.out.println("New Account Added!");
					return;
				} else if (choice == 3) {
//						CanteenApp.deleteAccount(accountList);
				} else {
					System.out.println("Account does not exist.");
				}

				break;
			case 2: // Menu Item

			case 2: // Menu Item -> Ryan


				String Menu[] = { "View Menu", "Add Menu Item", "Delete Menu Item" };
				String p = "";
				Helper.line(80, "-");
				System.out.println("MENU");
				Helper.line(80, "-");
				for (int i = 0; i < Menu.length; i++) {
					p += String.format("%d. %s\n", (i + 1), Menu[i]);
				}
				System.out.println(p);
				int menuC = Helper.readInt("Enter choice > ");

				switch (menuC) {
				case 1:
					viewAllMenuItem1(MenuList);
					break;
				case 2:
					addMenuItem1(MenuList);
					break;
				case 3:
					deleteMenuItem(MenuList);
					break;
				default:
					System.out.println("Invalid Input!");
					break;
				}
				break;

			case 3: // Start of Order -> By Vanessa
				String orderMenu[] = { "View Order", "Add Order", "Delete Order" };
				String output = "";
				Helper.line(80, "-");
				System.out.println("ORDER");
				Helper.line(80, "-");
				for (int i = 0; i < orderMenu.length; i++) {
					output += String.format("%d. %s\n", (i + 1), orderMenu[i]);
				}
				System.out.println(output);
				int order = Helper.readInt("Enter choice > ");

				switch (order) {
				case 1:
					viewAllOrder(OrderList);
					break;
				case 2:
					addOrder(OrderList);
					break;
				case 3:
					deleteOrder(OrderList);
					break;
				default:
					System.out.println("Invalid Input!");
				}
				break; // End of Order

			case 4: // Purchase Order

				break;

			case 5: // Promotion -> NICOLE
				CanteenApp.setHeader("PROMOTION");
				System.out.println("1. View Promotion");
				System.out.println("2. Add Promotion");
				System.out.println("3. Delete Promotion");
				int choice1 = Helper.readInt("Enter choice > ");
				if (choice1 == 1) {
					CanteenApp.viewAllPromotion(promotionList);
				} else if (choice1 == 2) {
					Promotion promo = inputPromotion();
					CanteenApp.addPromotion(promotionList, promo);
				} else if (choice1 == 3) {
					CanteenApp.deletePromotion(promotionList);

				String orderMenu[] = { "View Order", "Add Order", "Update Order", "Delete Order" };
				String output = "";
				Helper.line(80, "-");
				System.out.println("ORDER");
				Helper.line(80, "-");
				for (int i = 0; i < orderMenu.length; i++) {
					output += String.format("%d. %s\n", (i + 1), orderMenu[i]);
				}
				System.out.println(output);
				int order = Helper.readInt("Enter choice > ");

				switch (order) {
				case 1:
					viewAllOrder(OrderList);
					break;
				case 2:
					addOrder(OrderList);
					break;
				case 3:
					updateOrder(OrderList);
					break;
				case 4:
					deleteOrder(OrderList);
					break;				
				default:
					System.out.println("Invalid Input!");
					break;
				}
				break; // End of Order

			case 4: // Purchase Order -> Rai
				CanteenApp.setHeader("PURCHASE ORDER");
				System.out.println("1. View Purchase Order");
				System.out.println("2. Add Purchase Order");
				System.out.println("3. Delete Purchase Order");
				choice = Helper.readInt("Enter choice > ");

				if (choice == 1) {
					CanteenApp.viewPurchaseOrder(purchaseList);
				} else if (choice == 2) {
					CanteenApp.addPurchaseOrder(purchaseList);
				} else if (choice == 3) {
					CanteenApp.deletePurchaseOrder(purchaseList);
				} else {
					System.out.println("Invalid Choice Input.");
				}

				break;

			case 5: // Promotion -> NICOLE
				CanteenApp.setHeader("PROMOTION");
				System.out.println("1. View Promotion");
				System.out.println("2. Add Promotion");
				System.out.println("3. Delete Promotion");
				System.out.println("4. Update Promotion");
				choice = Helper.readInt("Enter choice > ");

				if (choice == 1) {
					CanteenApp.viewAllPromotion(promotionList);
				} else if (choice == 2) {
					CanteenApp.addPromotion(promotionList);
				} else if (choice == 3) {
					CanteenApp.deletePromotion(promotionList);
				} else if (choice == 4) {
					CanteenApp.updatePromotion(promotionList);
				} else {
					System.out.println("Invalid Choice Input.");
				}
				break;

			case 6:
				System.out.println("Bye!");
				break;

			default:
				System.out.println("Invalid option!");
				break;
			}
		}
	}

	/*
	 * =============================================================================
	 * ================================================
	 * 
	 * /*===========================================================================
	 * ==================================================
	 */

// Start -> By Vanessa:

	public static void optionMenu() {
		Helper.line(80, "-");
		System.out.println("MENU");
		Helper.line(80, "-");
		String output = "";
		String list[] = { "User Account", "Menu Item", "Order", "Purchase Order", "Promotions", "Exit" };
		for (int i = 0; i < list.length; i++) {
			output += String.format("%d. %s\n", (i + 1), list[i]);
		}
		System.out.println(output);

	}

// End
	/*
	 * =============================================================================
	 * ================================================
	 */
	// -----RyanStart-----\\


//Create MenuItem
	public static void createMenuItem(ArrayList<MenuItem> menuItemList) {
		String category = Helper.readString("Enter Category > ");
		String name = Helper.readString("Enter Name > ");
		double price = Helper.readDouble("Enter price > ");

		if (price > 0) {
			menuItemList.add(new MenuItem(category, name, price));
			System.out.println("Menu Item added!");
		} else {
			System.out.println("Price must be greater than 0");
		}
	}

	// Delete MenuItem
	public static void deleteMenuItem(ArrayList<MenuItem> menuItemList) {
		String deleteCategory = Helper.readString("Enter Menu Item Category to Remove > ");
		String deleteName = Helper.readString("Enter Menu Item Name to Remove > ");
		for (int i = 0; i < menuItemList.size(); i++) {
			if (deleteCategory.equals(menuItemList.get(i).getCategory())
					&& deleteName.equals(menuItemList.get(i).getName())) {
				menuItemList.remove(i);
				System.out.println("Menu Item Deleted!");
			} else {
				System.out.println("Delete failed!");
			}
		}
	}

	// Update MenuItem
	public static void updateMenuItem(ArrayList<MenuItem> menuItemList) {

		int option1 = 0;

		System.out.println("1. Update Name");
		System.out.println("2. Update Price");
		option1 = Helper.readInt("Enter option > ");

		if (option1 == 1) {
			Helper.line(60, "-");
			System.out.println("UPDATE NAME");
			Helper.line(60, "-");

			String updateName = Helper.readString("Enter Menu Item Name to update > ");
			boolean isUpdated = false;

			for (MenuItem m : menuItemList) {
				if (m.getName().equals(updateName)) {
					String newName = Helper.readString("Enter new name > ");
					m.setName(newName);
					isUpdated = true;
					System.out.println("***Menu item name updated!");
					break;
				}
			}

			if (isUpdated == false) {
				System.out.println("***Update Failed!");
			}

		} else if (option1 == 2) {
			Helper.line(60, "-");
			System.out.println("UPDATE PRICE");
			Helper.line(60, "-");

			String updateName = Helper.readString("Enter Menu Item Name to update > ");
			boolean isUpdated = false;

			for (MenuItem m : menuItemList) {
				if (m.getName().equals(updateName)) {
					double newPrice = Helper.readDouble("Enter new price > ");
					if (newPrice > 0) {
						m.setPrice(newPrice);
						isUpdated = true;
						System.out.println("***Menu item price updated!");
					} else {
						System.out.println("Price must be greater than 0");
					}
					break;
				}
			}

			if (isUpdated == false) {
				System.out.println("***Update failed!");
			}
		}
	}

	// View MenuItem
	public static void viewAllMenuItem(ArrayList<MenuItem> menuItemList) {
		int option = 0;

		System.out.println("1. View All Menu Item");
		System.out.println("2. View All Menu Items Grouped By Category");
		option = Helper.readInt("Enter option > ");

		if (option == 1) {
			Helper.line(60, "-");
			System.out.println("View All Menu Item");
			Helper.line(60, "-");

			String output = String.format("%-5s %-20s %-20s %-20s \n", "NO.", "CATEGORY", "NAME", "PRICE");
			for (int i = 0; i < menuItemList.size(); i++) {
				output += String.format("%-5s %-20s %-20s $%-20.2f \n", (i + 1), menuItemList.get(i).getCategory(),
						menuItemList.get(i).getName(), menuItemList.get(i).getPrice());
			}
			System.out.print(output);

		} else if (option == 2) {
			Helper.line(60, "-");
			System.out.println("View All Menu Items Grouped By Category");
			Helper.line(60, "-");

			if (!menuItemList.isEmpty()) {
				String searchCategory = Helper.readString("Enter category >");
				String output = String.format("%-5s %-20s %-20s %-20s \n", "NO.", "CATEGORY", "NAME", "PRICE");
				String menuCategory = "";
				boolean isFound = false;

				for (int i = 0; i < menuItemList.size(); i++) {
					menuCategory = menuItemList.get(i).getCategory();
					menuCategory = menuItemList.get(i).getCategory().toLowerCase();
					searchCategory = searchCategory.toLowerCase();

					if (menuCategory.contains(searchCategory)) {
						output += String.format("%-5s %-20s %-20s $%-20.2f \n", (i + 1),
								menuItemList.get(i).getCategory(), menuItemList.get(i).getName(),
								menuItemList.get(i).getPrice());

						isFound = true;
					}
				}

				if (isFound == false) {
					System.out.println("Menu Item Category not found");
				}
				System.out.println(output);
			}

		}
	}

	// Search MenuItem
	public static void searchMenuItem(ArrayList<MenuItem> menuItemList) {
		if (!menuItemList.isEmpty()) {
			String searchName = Helper.readString("Enter name >");
			String output = String.format("%-20s %-20s %-20s \n", "CATEGORY", "NAME", "PRICE");
			String menuName = "";
			boolean isFound = false;

			for (int i = 0; i < menuItemList.size(); i++) {
				menuName = menuItemList.get(i).getName();

				menuName = menuItemList.get(i).getCategory().toLowerCase();
				menuName = menuItemList.get(i).getName().toLowerCase();
				searchName = searchName.toLowerCase();

				if (menuName.contains(searchName)) {
					output += String.format("%-20s %-20s $%-20.2f \n", menuItemList.get(i).getCategory(),
							menuItemList.get(i).getName(), menuItemList.get(i).getPrice());

					isFound = true;
				}
			}

			if (isFound == false) {
				System.out.println("Menu Item name not found");
			}
			System.out.println(output);
		}

	}

	// -----RyanEnd-----\\
	/*
	 * =============================================================================
	 * ================================================
	 */
// Header by NICOLE
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	/*
	 * =============================================================================
	 * ================================================
	 */

	/*
	 * =============================================================================
	 * ================================================
	 */
// Start -> By Vanessa: (Works with menu (Menu Missing), Tested on my own mini sandbox)

	public static void addOrder(ArrayList<Order> items) {
		viewAllMenuItem1(MenuList);
		Helper.line(80, "-");
		System.out.println("Add Order");
		Helper.line(80, "-");

		ArrayList<MenuItem> items1 = new ArrayList<MenuItem>();
		String username = Helper.readString("Enter your username > ");
		String status = "Processing";
		boolean takeaway = Helper.readBoolean("Takeaway? (True/False) > ");

		String input = "";
		while (!input.equalsIgnoreCase("N")) {
			String item = Helper.readString("Enter food > ");
			boolean avail = false;

			for (MenuItem i : MenuList) {
				if (item.equalsIgnoreCase(i.getName())) {
					items1.add(new MenuItem(i.getCategory(), i.getName(), i.getPrice()));
					System.out.println("Food item added!\n");
					avail = true;
					break;
				}
			}
			if (avail == false) {
				System.out.println("Invalid food item!");
			}
			input = Helper.readString("Do you want to continue add food?(Y/N)> ");
		}

		System.out.println("Order placed.\n");
		OrderList.add(new Order(username, status, takeaway, items1));

	}

	public static void deleteOrder(ArrayList<Order> items) {
		viewAllOrder(OrderList);
		Helper.line(80, "-");
		System.out.println("Delete Order");
		Helper.line(80, "-");

		boolean checker = false;
		while (checker != true) {
			String input = Helper.readString("Enter username to remove > ");
			for (int i = 0; i < OrderList.size(); i++) {
				if (input.equalsIgnoreCase(OrderList.get(i).getUsername())) {
					OrderList.remove(i);
					System.out.println("Order deleted");
					checker = true;
				}
			}
			if (checker == false) {
				System.out.println("Username does not exist. \n");
			}
		}
	}

	public static void viewAllOrder(ArrayList<Order> items) {
		Helper.line(80, "-");
		System.out.println("View Orders");
		Helper.line(80, "-");

		String output = String.format("%-15s %-15s %-15s %-20s\n", "Username", "Status", "Takeaway", "Food Item");
		output += String.format("%-15s %-15s %-15s %-20s\n", "--------", "------", "--------", "---------");
		for (Order i : OrderList) {
			output += i.toString();
		}
		System.out.println(output);
	}
// End
	/*
	 * =============================================================================
	 * ================================================
	 */
	// User Account CREATE, VIEW, DELETE -> By Akhil:
	=======

// -----RyanEnd-----\\
	/*
	 * =============================================================================
	 * ================================================
	 */
// User Account CREATE, VIEW, DELETE -> By Akhil:
	>>>>>>>branch'master'

	of https:// github.com/sawsage1/C206_CaseStudy

	// Adding Account
	<<<<<<<HEAD

	=======>>>>>>>branch'master'
	of https:// github.com/sawsage1/C206_CaseStudy

	public static void addAccount(ArrayList<Account> accountList) {

		String userAccount = Helper.readString("Enter User Account Name: ");
		String accountPassword = Helper.readString("Enter Account Password: ");

		Account acc = new Account(userAccount, accountPassword);
		accountList.add(acc);
		System.out.println("New Account Added!");
		return;

	}

	// Retrieving account list.
	public static String retrieveAllAccounts(ArrayList<Account> accountList) {
		String output = "";
		for (int i = 0; i < accountList.size(); i++) {

			output += String.format("%-10s %-30s %-10.2f\n", accountList.get(i).getUsername(),
					accountList.get(i).getPassword(), accountList.get(i).getUserRole());

		}
		return output;
	}

	// Viewing Account List
	public static void viewAllAccounts(ArrayList<Account> accountList) {
		for (int i = 0; i < accountList.size(); i++) {
			CanteenApp.setHeader("ACCOUNT LIST");
			String output = String.format("%-10s %-30s %-10s\n", "USERNAME", "PASSWORD", "USER ROLE");
			output += retrieveAllAccounts(accountList);
			System.out.println(output);
		}

	}

	public static void deleteAccount(ArrayList<Account> accountList) {

		CanteenApp.viewAllAccounts(accountList);
		String username = Helper.readString("Enter Username > ");

		for (int i = 0; i < accountList.size(); i++) {
			if (username == accountList.get(i).getUsername()) {
				System.out.println("Staff " + username + "'s account has been deleted.");
			} else {
				System.out.println("Account does not exist.");
			}
		}
	}<<<<<<<HEAD

	/*
	 * =============================================================================
	 * ================================================
	 */
	=======

	/*
	 * =============================================================================
	 * ================================================
	 */
// Header by NICOLE
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	/*
	 * =============================================================================
	 * ================================================
	 */
// Start -> By Vanessa: (Works with menu (Menu Missing), Tested on my own mini sandbox)

	public static void addOrder(ArrayList<Order> items) {
		viewAllMenuItem1(MenuList);
		Helper.line(80, "-");
		System.out.println("Add Order");
		Helper.line(80, "-");

		ArrayList<MenuItem> items1 = new ArrayList<MenuItem>();
		String username = Helper.readString("Enter your username > ");
		String status = "Processing";
		boolean takeaway = Helper.readBoolean("Takeaway? (True/False) > ");

		String input = "";
		while (!input.equalsIgnoreCase("N")) {
			String item = Helper.readString("Enter food > ");
			boolean avail = false;

			for (MenuItem i : MenuList) {
				if (item.equalsIgnoreCase(i.getName())) {
					items1.add(new MenuItem(i.getCategory(), i.getName(), i.getPrice()));
					System.out.println("Food item added!\n");
					avail = true;
					break;
				}
			}
			if (avail == false) {
				System.out.println("Invalid food item!");
			}
			input = Helper.readString("Do you want to continue add food?(Y/N)> ");
		}

		System.out.println("Order placed.\n");
		OrderList.add(new Order(username, status, takeaway, items1));
	}

	public static void deleteOrder(ArrayList<Order> items) {
		viewAllOrder(OrderList);
		Helper.line(80, "-");
		System.out.println("Delete Order");
		Helper.line(80, "-");

		boolean checker = false;
		while (checker != true) {
			String input = Helper.readString("Enter username to remove > ");
			for (int i = 0; i < OrderList.size(); i++) {
				if (input.equalsIgnoreCase(OrderList.get(i).getUsername())) {
					OrderList.remove(i);
					System.out.println("Order deleted");
					checker = true;
				}
			}
			if (checker == false) {
				System.out.println("Username does not exist. \n");
			}
		}
	}

	public static void viewAllOrder(ArrayList<Order> items) {
		Helper.line(80, "-");
		System.out.println("View Orders");
		Helper.line(80, "-");

		String output = String.format("%-15s %-15s %-15s %-20s\n", "Username", "Status", "Takeaway", "Food Item");
		output += String.format("%-15s %-15s %-15s %-20s\n", "--------", "------", "--------", "---------");
		for (Order i : OrderList) {
			output += i.toString();
		}
		System.out.println(output);
	}

	public static void updateOrder(ArrayList<Order> items) {

	}

	/*
	 * =============================================================================
	 * ================================================
	 */
// By Rai
	public static void addPurchaseOrder(ArrayList<PurchaseOrder> purchaseList) {

		CanteenApp.setHeader("ADD PURCHASE ORDER");
		String itemName = Helper.readString("Enter item name > ");
		int itemQuantity = Helper.readInt("Enter item quanitity > ");
		double itemUnitPrice = Helper.readDouble("Enter item unit price > ");
		String deliveryDate = Helper.readString("Enter delivery date > ");

		PurchaseOrder po = new PurchaseOrder(itemName, itemQuantity, itemUnitPrice, deliveryDate);

		purchaseList.add(po);
		System.out.println("Purchase Order added!");

	}

	public static void deletePurchaseOrder(ArrayList<PurchaseOrder> purchaseList) {

		boolean isDeleted = false;
		String deleteOrder = Helper.readString("Enter item name to delete> ");

		for (int i = 0; i < purchaseList.size(); i++) {
			if (deleteOrder.equalsIgnoreCase(purchaseList.get(i).getItemName())) {
				purchaseList.remove(i);
				isDeleted = true;
				System.out.println("Purchase Order deleted!");
			}
		}
		if (isDeleted == false) {
			System.out.println("Purchase Order not deleted, as item was not found!");
		}
	}

	public static void viewPurchaseOrder(ArrayList<PurchaseOrder> purchaseList) {

		String output = String.format("%-20s %-20s %-20s\n", "PROMOTION CODE", "END DATE", "DISCOUNT AMOUNT");
		for (PurchaseOrder i : purchaseList) {
			output += i.toString();
		}
		System.out.println(output);

	}

	/*
	 * =============================================================================
	 * ================================================
	 */
	>>>>>>>branch'master'

	of https:// github.com/sawsage1/C206_CaseStudy
//Promotion ADD, VIEW DELETE BY NICOLE

	public static void addPromotion(ArrayList<Promotion> promotionList) {
		String promoCode = Helper.readString("Enter Promotion Code: ");
		String endingDate = Helper.readString("Enter Promotion End Date: ");
		ZoneId S = ZoneId.of("Singapore");
		LocalDate date = LocalDate.now(S);
		LocalDate ending = LocalDate.parse(endingDate);
		if (promoCode.startsWith("Promo") && date.isBefore(ending)) {
			double disAmount = Helper.readDouble("Enter Discount Amount: ");
			Promotion promo = new Promotion(promoCode, endingDate, disAmount);
			promotionList.add(promo);
			System.out.println("Promotion added");
		} else {
			System.out.println("input of promotion code or Date does not the requirement");
		}
	}

	<<<<<<<HEAD

	public static void addPromotion(ArrayList<Promotion> promotionList, Promotion promo) {
		promotionList.add(promo);
		System.out.println("Promotion added");
	}

	=======>>>>>>>branch'master'

	of https:// github.com/sawsage1/C206_CaseStudy

	public static Boolean doDeletePromotion(ArrayList<Promotion> promotionList, String promotionCode, String endDate) {

		boolean isDelete = false;

		for (int i = 0; i < promotionList.size(); i++) {

			String promoCode = promotionList.get(i).getPromotionCode();
			String endingDate = promotionList.get(i).getEndDate();

			if (promotionCode.equalsIgnoreCase(promoCode) && endDate.equalsIgnoreCase(endingDate)) {
				promotionList.remove(i);
				isDelete = true;
			}
		}
		return isDelete;
	}

	public static void deletePromotion(ArrayList<Promotion> promotionList) {
		CanteenApp.viewAllPromotion(promotionList);
		String promotionCode = Helper.readString("Enter Promotion Code: ");
		String endDate = Helper.readString("Enter End Date: ");
		Boolean isDelete = doDeletePromotion(promotionList, promotionCode, endDate);
		if (isDelete == false) {
			System.out.println("Invalid Promotion Code");
		} else {
			System.out.println(promotionCode + " Promotion deleted");
		}
	}

	public static String retrieveAllPromotion(ArrayList<Promotion> promotionList) {
		CanteenApp.setHeader("PROMOTION LIST");
		String output = "";
		for (int i = 0; i < promotionList.size(); i++) {
			output += String.format("%-60s\n", promotionList.get(i).toString());
		}
		return output;
	}

	public static void viewAllPromotion(ArrayList<Promotion> promotionList) {
		String output = String.format("%-20s %-20s %-20s\n", "PROMOTION CODE", "END DATE", "DISCOUNT AMOUNT");
		output += retrieveAllPromotion(promotionList);
		System.out.println(output);
	}<<<<<<<HEAD
	/*
	 * =============================================================================
	 * ================================================
	 */

	=======

	public static void updatePromotion(ArrayList<Promotion> promotionList) {
		String oldPromoCode = Helper.readString("Enter Old Promotion Code To Update: ");
		for (int i = 0; i < promotionList.size(); i++) {
			if (promotionList.get(i).getPromotionCode().equals(oldPromoCode)) {
				String newPromoCode = Helper.readString("Enter New promotion Code: ");
				String newEndingDate = Helper.readString("Enter New Promotion End Date: ");
				ZoneId S = ZoneId.of("Singapore");
				LocalDate date = LocalDate.now(S);
				LocalDate ending = LocalDate.parse(newEndingDate);
				if (newPromoCode.startsWith("Promo") && date.isBefore(ending)) {
					double newDisAmount = Helper.readDouble("Enter New Discount Amount: ");
					promotionList.get(i).setPromotionCode(newPromoCode);
					promotionList.get(i).setEndFate(newEndingDate);
					promotionList.get(i).setDiscountAmount(newDisAmount);
					System.out.println("Promotion Updateded");
				} else {
					System.out.println("input of promotion code or Date does not the requirement");
				}
			} else {
				System.out.println("Invalid promotion. Please try again");
			}
		}

	}

	/*
	 * =============================================================================
	 * ================================================
	 */
	>>>>>>>branch'master'

	of https:// github.com/sawsage1/C206_CaseStudy
}
