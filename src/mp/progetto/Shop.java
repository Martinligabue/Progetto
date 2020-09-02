package mp.progetto;

import java.util.ArrayList;

public class Shop extends Streams {// todo:add the default prices as default, also map?

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
/*
	public boolean containsName(final ArrayList<Game> list, final String gameName) {
		return list.stream().filter(o -> o.getName().equals(gameName)).findFirst().isPresent();
	}
*/
	
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
