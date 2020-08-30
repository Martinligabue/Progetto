package mp.progetto;

public class DiscountStrategyFactory {
	public static DiscountStrategy noDiscount() {
		return new DiscountStrategy() {
			@Override
			public int applyDiscount(int originalPrice) {
				return originalPrice;
			}
		};
	}

	public static DiscountStrategy absoluteDiscount(int discount) {
		return new DiscountStrategy() {
			@Override
			public int applyDiscount(int originalPrice) {
				return originalPrice - discount;
			}
		};
	}

	public static DiscountStrategy percentageDiscount(int percentage) {
		return new DiscountStrategy() {
			@Override
			public int applyDiscount(int originalPrice) {
				return originalPrice - (originalPrice * percentage / 100);
			}
		};
	}
}