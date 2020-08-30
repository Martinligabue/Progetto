package mp.progetto;

public class SummerSaleStrategy implements DiscountStrategy {
	private double percentage;

	public SummerSaleStrategy(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public double applyDiscount(double originalPrice) {
		return originalPrice - (originalPrice * percentage / 100);
	}
}