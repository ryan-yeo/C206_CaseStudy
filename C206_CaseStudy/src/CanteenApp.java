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
					viewAllMenuItem(MenuList);
					break;
				case 2:
					addMenuItem(MenuList);
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

/*=============================================================================================================================*/
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
	
	public static void userTypeMenu() {
		Helper.line(80, "-");
		System.out.println("USER TYPE MENU");
		Helper.line(80, "-");
		String output = "";
		String list[] = { "Canteen Admin", "Stall Staff", "Customer" };
		for (int i = 0; i < list.length; i++) {
			output += String.format("%d. %s\n", (i + 1), list[i]);
		}
		System.out.println(output);
	}
	
/*=============================================================================================================================*/
// -----RyanStart-----\\
	private static void deleteMenuItem(ArrayList<MenuItem> menuList2) {
		CanteenApp.viewAllMenuItem(MenuList);
		String itemName = Helper.readString("Enter Username > ");

		for (int i = 0; i < MenuList.size(); i++) {
//			if (itemName == MenuList.get(i).getItemName()) {
				System.out.println("Staff " + itemName + "'s account has been deleted.");
//			} else {
				System.out.println("Account does not exist.");
//			}
		}
	}

	private static void addMenuItem(ArrayList<MenuItem> menuList2) {
		String category = Helper.readString("Enter Category:");
		String itemName = Helper.readString("Enter User item Name: ");
		double price = Helper.readDouble("Enter item price: ");

		MenuItem a = new MenuItem(category, itemName, price);
		MenuList.add(a);
		System.out.println("New Item Added!");
		return;

	}

	private static String viewAllMenuItem(ArrayList<MenuItem> menuList2) {
		String output = "";
		for (int i = 0; i < MenuList.size(); i++) {

//					output += String.format("%-10s %-30s %-10.2f\n", MenuList.get(i).getCategory(),
//							MenuList.get(i).getItemName(), MenuList.get(i).getPrice());

		}
		return output;

	}
	
// -----RyanEnd-----\\
/*=============================================================================================================================*/
// User Account CREATE, VIEW, DELETE -> By Akhil:

	// Adding Account
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
	}
	
/*=============================================================================================================================*/
// Header by NICOLE
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
/*=============================================================================================================================*/
// Start -> By Vanessa: (Works with menu (Menu Missing), Tested on my own mini sandbox)

	public static void addOrder(ArrayList<Order> items) {
		viewAllMenuItem(MenuList);
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
	
/*=============================================================================================================================*/
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

/*=============================================================================================================================*/
//Promotion ADD, VIEW DELETE BY NICOLE
	public static void addPromotion(ArrayList<Promotion> promotionList) {
		String promoCode = Helper.readString("Enter Promotion Code: ");
		String endingDate = Helper.readString("Enter Promotion End Date: ");
		ZoneId S = ZoneId.of("Singapore");
		LocalDate date = LocalDate.now(S);
		LocalDate ending = LocalDate.parse(endingDate);
		if(promoCode.startsWith("Promo") && date.isBefore(ending)) {
			double disAmount = Helper.readDouble("Enter Discount Amount: ");
			Promotion promo = new Promotion(promoCode, endingDate, disAmount);
			promotionList.add(promo);
			System.out.println("Promotion added");
		}
		else {
			System.out.println("input of promotion code or Date does not the requirement");
		}
	}

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
	}
	
	public static void updatePromotion(ArrayList<Promotion> promotionList) {
		String oldPromoCode = Helper.readString("Enter Old Promotion Code To Update: ");
		for (int i = 0; i < promotionList.size(); i++) {
			if(promotionList.get(i).getPromotionCode().equals(oldPromoCode)) {
				String newPromoCode = Helper.readString("Enter New promotion Code: ");
				String newEndingDate = Helper.readString("Enter New Promotion End Date: ");
				ZoneId S = ZoneId.of("Singapore");
				LocalDate date = LocalDate.now(S);
				LocalDate ending = LocalDate.parse(newEndingDate);
				if(newPromoCode.startsWith("Promo") && date.isBefore(ending)) {
					double newDisAmount = Helper.readDouble("Enter New Discount Amount: ");
					promotionList.get(i).setPromotionCode(newPromoCode);
					promotionList.get(i).setEndFate(newEndingDate);
					promotionList.get(i).setDiscountAmount(newDisAmount);
					System.out.println("Promotion Updateded");
				}
				else {
					System.out.println("input of promotion code or Date does not the requirement");
				}
			}
			else {
				System.out.println("Invalid promotion. Please try again");
			}
		}
		
	}
	
/*=============================================================================================================================*/
}
