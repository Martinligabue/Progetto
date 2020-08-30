package mp.progetto;

public class CouponStrategy implements DiscountStrategy {
	private double discount;

	public CouponStrategy(double discount) {
		this.discount = discount;
	}

	@Override
	public double applyDiscount(double originalPrice) {
		return originalPrice - discount;
	}
}
