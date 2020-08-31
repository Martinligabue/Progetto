package mp.progetto;

import java.util.ArrayList;

public class Shop {// todo:add the default prices as default, also map?

	private static ArrayList<Game> gameList = new ArrayList<>();

	public void addGame(String name, double d) {
		gameList.add(new Game(name, d));
	}

	public final static ArrayList<Game> getGameList() {
		return gameList;
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
