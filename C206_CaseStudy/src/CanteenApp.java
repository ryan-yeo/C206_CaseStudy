import java.util.ArrayList;

public class CanteenApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Start - By Vanessa: 
		int option = 0;
		ArrayList<Order> OrderList = new ArrayList<Order>();
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		// End
		
		
		
		
		// By Vanessa:
		while (option!=6) {
			CanteenApp.optionMenu();
			option = Helper.readInt("Enter option > ");
			
			switch (option) {
				case 1: // User Account
					
					
					break;
					
				case 2: // Menu Item
					
					
					break;
					
				case 3: // Start of Order -> By Vanessa
					
					String orderMenu[] = {"View Order", "Add Order", "Delete Order"};
					String output = "";
					Helper.line(30, "-");
					System.out.println("ORDER MENU");
					Helper.line(30, "-");
					for (int i = 0; i < orderMenu.length; i++) {
						output += String.format("%d. %s\n", (i+1), orderMenu[i]);
					}
					System.out.println(output);
					int order = Helper.readInt("Enter choice > ");
					
					switch (order) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						default:
							System.out.println("Invalid Input!");
					}
					break;	// End of Order
					
				case 4: // Purchase Order
					
					
					break;
					
				case 5: // Promotion -> NICOLE5 
					CanteenApp.setHeader("PROMOTION MENU");
					System.out.println("1. View Promotion");
					System.out.println("2. Add Promotion");
					System.out.println("3. Delete Promotion");
					int choice = Helper.readInt("Enter choice > ");
					if(choice == 1) {
						CanteenApp.viewAllPromotion(promotionList);
					}
					else if(choice == 2){
						Promotion promo = inputPromotion();
						CanteenApp.addPromotion(promotionList, promo);
					}
					else if(choice == 3) {
						
					}
					else {
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
		Helper.line(30, "-");
		System.out.println("MENU");
		Helper.line(30, "-");
		String output = "";
		String list[] = {"User Account", "Menu Item", "Order", "Purchase Order", "Promotions", "Exit"};
		for (int i = 0; i < list.length; i++) {
			output += String.format("%d. %s\n", (i+1), list[i]);
		}
		System.out.println(output);
		
	}
// End
/*=============================================================================================================================*/	
	
/*=============================================================================================================================*/
// Header by NICOLE
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
/*=============================================================================================================================*/
	

	
	
	
/*=============================================================================================================================*/
// Start -> By Vanessa:
	public static void addOrder(ArrayList<Order> items) {	
	}
	
	public static void deleteOrder(ArrayList<Order> items) {	
	}
	
	public static void viewAllOrder(ArrayList<Order> items) {	
	}
// End
/*=============================================================================================================================*/

/*=============================================================================================================================*/
//Promotion ADD, VIEW DELETE BY NICOLE
	public static Promotion inputPromotion() {
		String promoCode = Helper.readString("Enter Promotion Code: ");
		String endingDate = Helper.readString("Enter Promotion End Date: ");
		double disAmount = Helper.readDouble("Enter Discount Amount: ");

		Promotion promo = new Promotion(promoCode, endingDate, disAmount);
		return promo;

	}
	public static void addPromotion(ArrayList<Promotion> promotionList, Promotion promo) {	
		promotionList.add(promo);
		System.out.println("Promotion added");
	}
	public static void deletePromotion(ArrayList<Promotion> promotionList) {	
		
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
/*=============================================================================================================================*/

}
