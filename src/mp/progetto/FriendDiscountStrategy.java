package mp.progetto;

public class FriendDiscountStrategy implements DiscountStrategy {
	@Override
	public double applyDiscount(double originalPrice) {
		return originalPrice;
	}
}