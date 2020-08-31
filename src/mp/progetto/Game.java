package mp.progetto;

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
}
