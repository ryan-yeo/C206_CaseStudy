
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19005075, 21 Aug 2020 11:27:30 am
 */

public class PurchaseOrder {

	private String itemName;
	private int itemQuantity;
	private double itemUnitPrice;
	private String deliveryDate;

	/**
	 * @param itemName
	 * @param itemQuantity
	 * @param itemUnitPrice
	 * @param deliveryDate
	 */
	public PurchaseOrder(String itemName, int itemQuantity, double itemUnitPrice, String deliveryDate) {
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemUnitPrice = itemUnitPrice;
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemQuantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	/**
	 * @return the itemUnitPrice
	 */
	public double getItemUnitPrice() {
		return itemUnitPrice;
	}

	/**
	 * @param itemUnitPrice the itemUnitPrice to set
	 */
	public void setItemUnitPrice(double itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}

	/**
	 * @return the deliveryDate
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String toString() {
		return String.format("%-20s %-20d -$%20.2f -%s\n", getItemName(), getItemQuantity(), getItemUnitPrice(),
				getDeliveryDate());

	}

}
