package mp.progetto;

import java.util.ArrayList;

public class Shop extends Streams {

	private static ArrayList<Game> gameList = new ArrayList<>();

	public void addGame(String name, double d) {
		gameList.add(new Game(name, d));
	}

	public void clean() {
		gameList.removeAll(gameList);
	}

	public void addDefaultGames() {
		this.addGame("Klondike", 0);
		this.addGame("Spider", 10);
		this.addGame("Freecell", 50);
		this.addGame("Tripeaks", 15.5);
	}

	public final ArrayList<Game> getGameList() {
		return gameList;
	}

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
