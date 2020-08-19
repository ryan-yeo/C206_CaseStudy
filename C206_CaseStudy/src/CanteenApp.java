import java.util.ArrayList;

public class CanteenApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Start - By Vanessa: 
		optionMenu();
		int option = 0;
		ArrayList<Order> OrderList = new ArrayList<Order>();
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		// End
		
		
		
		
		// By Vanessa:
		while (option!=6) {
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
					Helper.line(30, "-");
					System.out.println("Promotion MENU");
					Helper.line(30, "-");
					System.out.println("1. View Promotion");
					System.out.println("2. Add Promotion");
					System.out.println("3. Delete Promotion");
					int choice = Helper.readInt("Enter choice > ");
					if(choice == 1) {
						
					}
					else if(choice == 2){
						
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
	public static void addPromotion(ArrayList<Promotion> promotionList) {	
		
	}
	public static void deletePromotion(ArrayList<Promotion> promotionList) {	
		
	}
	public static void viewAllPromotion(ArrayList<Promotion> PromotionList) {	
		
	}
/*=============================================================================================================================*/

}
