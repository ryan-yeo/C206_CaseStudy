import java.util.ArrayList;

public class CanteenApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// By Vanessa: 
		optionMenu();
		int option = 0;
		
		// By Vanessa:
		while (option!=6) {
			option = Helper.readInt("Enter option > ");
			
			switch (option) {
				case 1:
					// user account
					
					break;
					
				case 2:
					// menu item
					
					break;
					
				case 3:
					// order
					
					break;
					
				case 4:
					// purchase order
					
					break;
					
				case 5:
					// promotion
					
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
// By Vanessa:
	public static void optionMenu() {
		Helper.line(60, "-");
		System.out.println("MENU");
		Helper.line(60, "-");
		String output = "";
		String list[] = {"User Account", "Menu Item", "Order", "Purchase Order", "Promotions", "Exit"};
		for (int i = 0; i < list.length; i++) {
			output += String.format("%d. %s\n", (i+1), list[i]);
		}
		System.out.println(output);
		
	}
	
/*=============================================================================================================================*/
// By Vanessa:
	public static void addOrder(ArrayList<Order> items) {
		
	}
	
	public static void deleteOrder(ArrayList<Order> items) {
		
	}
	
	public static void viewAllOrder(ArrayList<Order> items) {
		
	}
/*=============================================================================================================================*/

}
