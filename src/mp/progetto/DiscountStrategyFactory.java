package mp.progetto;

public class DiscountStrategyFactory {
	public static DiscountStrategy noDiscount() {
		return originalPrice -> originalPrice;
	}

	public static DiscountStrategy coupon(int discount) {
		return originalPrice -> originalPrice - discount;
	}

	public static DiscountStrategy summerSale() {
		return originalPrice -> originalPrice * 0.8;
	}

	public static DiscountStrategy friendDiscount(int friends) {
		return originalPrice -> originalPrice - (originalPrice * 0.1 * friends);
	}
}