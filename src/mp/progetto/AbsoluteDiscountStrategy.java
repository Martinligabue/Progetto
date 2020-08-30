package mp.progetto;

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
