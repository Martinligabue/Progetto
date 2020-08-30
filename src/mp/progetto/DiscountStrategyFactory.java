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
}