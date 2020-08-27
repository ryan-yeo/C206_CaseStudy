import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CanteenApp {

	// Start - By Vanessa:
	private static ArrayList<Order> OrderList = new ArrayList<Order>();
	// End
	
	// -----RyanStart-----\\
	private static ArrayList<MenuItem> MenuList = new ArrayList<MenuItem>();
	// -----RyanEnd-----\\

	//Start - Akhil
	private static ArrayList<Account> accountList = new ArrayList<Account>();
	// End
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		// Akhil
		accountList.add(new Account("vanny", "pass"));
		
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

				
				if (choice == 1) {
					CanteenApp.viewAccount(accountList);
				} else if (choice == 2) {
					addAccount(accountList);
				} else if (choice == 3) {
				CanteenApp.deleteAccount(accountList);
				} else {
					System.out.println("Account does not exist.");
				}


				break;

			case 2: // Menu Item

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
				String orderMenu[] = { "View Order", "Add Order", "Update Order", "Delete Order" };
				String output = "";
				Helper.line(100, "-");
				System.out.println("ORDER");
				Helper.line(100, "-");
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
					String updateMenu[] = { "Order Status", "Order Takeaway Flag", };
					String output1 = "";
					Helper.line(100, "-");
					System.out.println("UPDATE ORDER");
					Helper.line(100, "-");
					for (int i = 0; i < updateMenu.length; i++) {
						output1 += String.format("%d. %s\n", (i + 1), updateMenu[i]);
					}
					System.out.println(output1);
					int update = Helper.readInt("Enter choice > ");
					
					switch (update) {
					case 1:
						updateOrderStatus(OrderList);
						break;
					case 2:
						updateOrderTakeaway(OrderList);
						break;
					}
					break;
				case 4:
					deleteOrder(OrderList);
					break;				
				default:
					System.out.println("Invalid Input!");
					break;
				}
				break; // End of Order

			case 4: // Purchase Order

				break;

			case 5: // Promotion -> NICOLE
				CanteenApp.setHeader("PROMOTION");
				System.out.println("1. View Promotion");
				System.out.println("2. Add Promotion");
				System.out.println("3. Delete Promotion");
				System.out.println("4. Update Promotion");
				int choice1 = Helper.readInt("Enter choice > ");
				if (choice1 == 1) {
					CanteenApp.viewAllPromotion(promotionList);
				} else if (choice1 == 2) {
					CanteenApp.addPromotion(promotionList);
				} else if (choice1 == 3) {
					CanteenApp.deletePromotion(promotionList);
				} else if (choice1 == 4) {
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

// End
/*=============================================================================================================================*/
	// -----RyanStart-----\\


	//Create MenuItem
		public static void addMenuItem(ArrayList<MenuItem> menuItemList) {
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
		public static void updateMenuItem(ArrayList<MenuItem> menuList) {

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

				for (MenuItem m : menuList) {
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

				for (MenuItem m : menuList) {
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
		public static void viewAllMenuItem(ArrayList<MenuItem> menuList) {
			int option = 0;

			System.out.println("1. View All Menu Item");
			System.out.println("2. View All Menu Items Grouped By Category");
			option = Helper.readInt("Enter option > ");

			if (option == 1) {
				Helper.line(60, "-");
				System.out.println("View All Menu Item");
				Helper.line(60, "-");

				String output = String.format("%-5s %-20s %-20s %-20s \n", "NO.", "CATEGORY", "NAME", "PRICE");
				for (int i = 0; i < menuList.size(); i++) {
					output += String.format("%-5s %-20s %-20s $%-20.2f \n", (i + 1), menuList.get(i).getCategory(),
							menuList.get(i).getName(), menuList.get(i).getPrice());
				}
				System.out.print(output);

			} else if (option == 2) {
				Helper.line(60, "-");
				System.out.println("View All Menu Items Grouped By Category");
				Helper.line(60, "-");

				if (!menuList.isEmpty()) {
					String searchCategory = Helper.readString("Enter category >");
					String output = String.format("%-5s %-20s %-20s %-20s \n", "NO.", "CATEGORY", "NAME", "PRICE");
					String menuCategory = "";
					boolean isFound = false;

					for (int i = 0; i < menuList.size(); i++) {
						menuCategory = menuList.get(i).getCategory();
						menuCategory = menuList.get(i).getCategory().toLowerCase();
						searchCategory = searchCategory.toLowerCase();

						if (menuCategory.contains(searchCategory)) {
							output += String.format("%-5s %-20s %-20s $%-20.2f \n", (i + 1),
									menuList.get(i).getCategory(), menuList.get(i).getName(),
									menuList.get(i).getPrice());

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
		public static void searchMenuItem(ArrayList<MenuItem> menuList) {
			if (!menuList.isEmpty()) {
				String searchName = Helper.readString("Enter name >");
				String output = String.format("%-20s %-20s %-20s \n", "CATEGORY", "NAME", "PRICE");
				String menuName = "";
				boolean isFound = false;

				for (int i = 0; i < menuList.size(); i++) {
					menuName = menuList.get(i).getName();

					menuName = menuList.get(i).getCategory().toLowerCase();
					menuName = menuList.get(i).getName().toLowerCase();
					searchName = searchName.toLowerCase();

					if (menuName.contains(searchName)) {
						output += String.format("%-20s %-20s $%-20.2f \n", menuList.get(i).getCategory(),
								menuList.get(i).getName(), menuList.get(i).getPrice());

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
/*=============================================================================================================================*/
// Header by NICOLE
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

/*=============================================================================================================================*/
// Start -> By Vanessa: (Works with menu (Menu Missing), Tested on my own mini sandbox)

	public static void MyViewAllMenuItem(ArrayList<MenuItem> items) {
		Helper.line(80, "-");
		System.out.println("View Menu Items");
		Helper.line(80, "-");
		
		String output = String.format("%-20s %-20s %s\n", "Category", "Name", "Price");
		output += String.format("%-20s %-20s %s\n", "--------", "----", "-----");
		for (MenuItem i : MenuList) {
			output += i.toString();
		}
		System.out.println(output);
	}
	
	public static void viewAllOrder(ArrayList<Order> items) {
		Helper.line(100, "-");
		System.out.println("View Orders");
		Helper.line(100, "-");
		
		if (items.isEmpty()) {
			System.out.println("*** No Orders Placed ***\n");
		} else {
			String output = String.format("%-15s %-13s %-10s %-13s %-25s %s\n", "Username", "Status", "Takeaway", "Pre-Order", "Collection Date & Time", "Food Item");
			output += String.format("%-15s %-13s %-10s %-13s %-25s %s\n", "--------", "------", "--------", "---------", "----------------------", "---------");
			
			for (Order i : items) {
				output += i.toString();
			}
			System.out.println(output);
		}
	}
	
	public static void addOrder(ArrayList<Order> items) {
	
		Helper.line(100, "-");
		System.out.println("Add Order");
		Helper.line(100, "-");
		
		ArrayList<MenuItem> items1 = new ArrayList<MenuItem>();
		
		String username = "";
		while (username.isBlank()) {
			username = Helper.readString("Enter your username > ");
			if (username.isBlank()) {
				System.out.println("Username cannot be empty!\n");
			}
		}
		
		String status = "Processing";
		boolean takeaway = Helper.readBoolean("Takeaway? (True/False) > ");
		boolean preOrder = Helper.readBoolean("Pre-order? (True/False) > ");
		System.out.println("");
		String patternDate = "(0[1-9]||[1-2][0-9]||30)-(0[1-9]||1[0-2])-202[0-1]";
		String patternTime = "([0-1][0-9]||2[0-3]):([0-5][0-9])";
		
		String inputdate, inputtime, DateTime = "";
		if (preOrder == true) {
			LocalDateTime date = null;
			LocalDateTime current = LocalDateTime.now();
			while (date == null) {
				inputdate = Helper.readString("Enter collection date (DD-MM-YYYY) > ");
				inputtime = Helper.readStringRegEx("Enter collection time (HH:MM) >", patternTime); 	// add a method in the Helper.java
				System.out.println("");
				if (Pattern.matches(patternDate, inputdate)) {
					DateTime = inputdate + " " + inputtime;
					LocalDateTime input1 = LocalDateTime.parse(DateTime, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
					if (input1.isAfter(current) || input1.isEqual(current)) {
						if (ChronoUnit.DAYS.between(current, input1) >= 1) {
							date = input1;
						} else {
							System.out.println("Date entered must be at least 1 days in advance.\n");
						}
					} else {
						System.out.println("*** Time entered has passed. Enter a valid date and time ***\n");
					}
				} else {
					System.out.println("Enter date in given format!\n");
				}
			}	
		}
	
		String input = "";
		double price = 0;
		
		MyViewAllMenuItem(MenuList);
		while (!input.equalsIgnoreCase("N")) {
			String item = Helper.readString("Enter food > ");
			boolean avail = false;
			
			for (MenuItem i: MenuList) {
				if (item.equalsIgnoreCase(i.getName())) {
					items1.add(new MenuItem(i.getCategory(), i.getName(), i.getPrice()));
					System.out.println("Food item added!");
					price += i.getPrice();
					System.out.println("$" + i.getPrice() + " added to the total payment.");
					System.out.println("Total Cost of Order currently: $" + price + "\n");
					avail = true;
					break;
				}
			}
			if (avail == false) {
				System.out.println("Invalid food item!");
			}
			input = Helper.readString("Do you want to continue add food?(Y/N)> ");
		}
	
		System.out.println("Order placed.");
		System.out.println("Total Cost of Order: $" + price + "\n");
		if (preOrder == true) {
			items.add(new Order(username, status, takeaway, preOrder, DateTime, items1));
		} else {
			items.add(new Order(username, status, takeaway, items1));
		}
		
		
	}
	
	public static void deleteOrder(ArrayList<Order> items) {
		viewAllOrder(items);
		Helper.line(100, "-");
		System.out.println("Delete Order");
		Helper.line(100, "-");
		
		if (items.isEmpty()) {
			System.out.println("*** There is no orders to delete ***\n");
		} else {
			boolean checker = false;
			while (checker != true) {
				String input = Helper.readString("Enter username to remove > ");
				for(int i=0; i<items.size(); i++) {
					if (input.equalsIgnoreCase(items.get(i).getUsername())) {
						items.remove(i);
						System.out.println("Order deleted");
						checker = true;
					}
				}
				if (checker == false) {
					System.out.println("Username does not exist. \n");
				}
			}
		}
	}
	
	public static void updateOrderStatus(ArrayList<Order> items) {
		Helper.line(100, "-");
		System.out.println("Update Order");
		Helper.line(100, "-");
		
		String updateStatus = "";
		
		if (items.isEmpty()) {
			System.out.println("*** There is no orders to update ***\n");
		} else {
			boolean checker = false;
			String output = "";
			output = String.format("%-15s %-13s %-10s %-13s %-25s %s\n", "Username", "Status", "Takeaway", "Pre-Order", "Collection Date & Time", "Food Item");
			output += String.format("%-15s %-13s %-10s %-13s %-25s %s\n", "--------", "------", "--------", "---------", "----------------------", "---------");
			while (checker != true) {
				String input = Helper.readString("Enter username > ");
				for(int i=0; i<items.size(); i++) {
					if (input.equalsIgnoreCase(items.get(i).getUsername())) {
						output += items.get(i).toString();
						checker = true;
					}
				}
				if (checker == false) {
					System.out.println("Username does not exist. \n");
				} else if (checker == true) {
					System.out.println(output);
					System.out.println("");
					int j = 0;
					for(int i=0; i<items.size(); i++) {
						if (input.equalsIgnoreCase(items.get(i).getUsername())) {
							System.out.println("Order " + (j+1) +":");
							updateStatus = Helper.readString("Enter order status to update > ");
							items.get(i).setStatus(updateStatus);
							System.out.println("Order Status Updated!\n");
							j++;
						}
					}
				}
			}
		}
	}
	
	public static void updateOrderTakeaway(ArrayList<Order> items) {
		Helper.line(100, "-");
		System.out.println("Update Order");
		Helper.line(100, "-");
		
		boolean takeawayFlag;
		
		if (items.isEmpty()) {
			System.out.println("*** There is no orders to update ***\n");
		} else {
			boolean checker = false;
			String output = "";
			output = String.format("%-15s %-13s %-10s %-13s %-25s %s\n", "Username", "Status", "Takeaway", "Pre-Order", "Collection Date & Time", "Food Item");
			output += String.format("%-15s %-13s %-10s %-13s %-25s %s\n", "--------", "------", "--------", "---------", "----------------------", "---------");
			while (checker != true) {
				String input = Helper.readString("Enter username > ");
				
				for(int i=0; i<items.size(); i++) {
					if (input.equalsIgnoreCase(items.get(i).getUsername())) {
						output += items.get(i).toString();
						checker = true;
					}
				}
				if (checker == false) {
					System.out.println("Username does not exist. \n");
				} else if (checker == true) {
					System.out.println(output);
					System.out.println("");
					int j = 0;
					for(int i=0; i<items.size(); i++) {
						if (input.equalsIgnoreCase(items.get(i).getUsername())) {
							System.out.println("Order " + (j+1) +":");
							takeawayFlag = Helper.readBoolean("Enter Takeaway Flag to update > ");
							items.get(i).setTakeaway(takeawayFlag);
							System.out.println("Order Takeaway Flag Updated!\n");
							j++;
						}
					}
				}
			}
		}
	}

// End
/*=============================================================================================================================*/
	// User Account CREATE, VIEW, DELETE -> By Akhil:

	// Add Account
	public static void addAccount(ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		String uName = Helper.readString("Enter username> ");
		String uPassword = Helper.readString("Enter password> ");
		
		Account uAcc = new Account(uName, uPassword);
		accountList.add(uAcc);
		System.out.println("Account added!");
	}

	//Retrieve Account
	public static String retrieveAllAccount(ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {

			output += String.format("%-10s %-20s\n", accountList.get(i).getUsername(),
					accountList.get(i).getPassword());
		}
		return output;
	}

	// View Account
	public static void viewAccount(ArrayList<Account> accountList) {

		if (accountList.isEmpty()) {
			System.out.println("No user account added\n");
		} else {
			
			String output = String.format("%-10s %-20s\n", "NAME", "PASSWORD");
			output += retrieveAllAccount(accountList);
			System.out.println(output);
		}
	}

	// Delete Account
	public static void deleteAccount(ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		
		String user = Helper.readString("Enter user account> ");
		
		for (int i = 0; i < accountList.size(); i++) {

			if (accountList.get(i).getUsername().equals(user)) {
				accountList.remove(i);
				System.out.println("Account removed!");
			}
		}
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
