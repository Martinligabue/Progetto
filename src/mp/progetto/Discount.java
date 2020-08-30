package mp.progetto;

public class Discount {// strategy
	public class NoDiscountStrategy implements DiscountStrategy {
		@Override
		public int applyDiscount(int originalPrice) {
			return originalPrice;
		}
	}

	public class AbsoluteDiscountStrategy implements DiscountStrategy {
		private int discount;

		public AbsoluteDiscountStrategy(int discount) {
			this.discount = discount;
		}

		@Override
		public int applyDiscount(int originalPrice) {
			return originalPrice - discount;
		}
	}

	public class PercentageDiscountStrategy implements DiscountStrategy {
		private int percentage;

		public PercentageDiscountStrategy(int percentage) {
			this.percentage = percentage;
		}

		@Override
		public int applyDiscount(int originalPrice) {
			return originalPrice - (originalPrice * percentage / 100);
		}
	}
}
