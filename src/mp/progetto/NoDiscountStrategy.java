package mp.progetto;

public class NoDiscountStrategy implements DiscountStrategy {
	@Override
	public int applyDiscount(int originalPrice) {
		return originalPrice;
	}
}
