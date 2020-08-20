
// By NICOLE
public class Promotion {
	private String promotionCode;
	private String endDate;
	private double discountAmount;
	
	public Promotion(String promotionCode, String endDate, double discountAmount) {
		this.promotionCode = promotionCode;
		this.endDate = endDate;
		this.discountAmount = discountAmount;
	}
	public String getPromotionCode() {
		return promotionCode;
	}
	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndFate(String endDate) {
		this.endDate = endDate;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String toString() {
		return String.format("%-20s %-20s $%.2f\n", getPromotionCode(), getEndDate(), getDiscountAmount());
	}
}
