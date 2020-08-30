package mp.progetto;

import java.util.ArrayList;
import java.util.Arrays;

public class Shop {// todo:add the default prices as default, also map?
	static ArrayList<String> gameList = new ArrayList<>(Arrays.asList("Game1", "Game2", "Game3", "Game4"));
	static Double[] array = { 0.0, 10.0, 50.0, 24.6 };
	static ArrayList<Double> prices = new ArrayList<Double>(Arrays.asList(array));

	public static ArrayList<String> getGameList() {
		return gameList;
	}

	public static ArrayList<Double> getPrices() {
		return prices;
	}

////////////

	private DiscountStrategy discountStrategy;

	public Shop(DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}

	public void setDiscountStrategy(DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}

	public double getTotal(double originalPrice) {
		return discountStrategy.applyDiscount(originalPrice);
	}

}
