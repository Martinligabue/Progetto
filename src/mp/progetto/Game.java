package mp.progetto;

import java.util.ArrayList;

public class Game {
	String name;
	double price;

	public final String getName() {
		return name;
	}

	public final double getPrice() {
		return price;
	}

	public Game(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public boolean containsName(final ArrayList<Game> list, final String name) {
		return list.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent();
	}
}
