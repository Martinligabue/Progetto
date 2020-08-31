package mp.progetto;

import java.util.ArrayList;

public class Shop {// todo:add the default prices as default, also map?

	private static ArrayList<Game> gameList = new ArrayList<>();

	public void addGame(String name, double d) {
		gameList.add(new Game(name, d));
	}

	public void addDefaultGames(Shop shop) {
		shop.addGame("Klondike", 0);
		shop.addGame("Spider", 10);
		shop.addGame("Freecell", 50);
		shop.addGame("Tripeaks", 15.5);
	}

	public final static ArrayList<Game> getGameList() {
		return gameList;
	}

	public boolean containsName(final ArrayList<Game> list, final String gameName) {
		return list.stream().filter(o -> o.getName().equals(gameName)).findFirst().isPresent();
	}

////////////

	private DiscountStrategy discountStrategy;

	public Shop() {
	}

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
