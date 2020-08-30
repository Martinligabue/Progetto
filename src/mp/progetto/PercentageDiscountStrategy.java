package mp.progetto;

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