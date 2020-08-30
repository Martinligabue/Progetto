package mp.progetto;

public class DiscountStrategyFactory {
	public static DiscountStrategy noDiscount() {
		return originalPrice -> originalPrice;
	}

	public static DiscountStrategy absoluteDiscount(int discount) {
		return originalPrice -> originalPrice - discount;
	}

	public static DiscountStrategy percentageDiscount(int percentage) {
		return originalPrice -> originalPrice - (originalPrice * percentage / 100);
	}
}