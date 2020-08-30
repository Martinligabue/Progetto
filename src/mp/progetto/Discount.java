package mp.progetto;

public class Discount {// strategy
	public static DiscountStrategy plain() {
		return price -> price;

	}

	public static DiscountStrategy friends(int friends) {
		return price -> price * (1 / friends);

	}

	public static DiscountStrategy coupon(double discount) {
		return price -> price - discount;

	}

	public static DiscountStrategy summerSale() {
		return price -> price * 0.8;

	}
}
