package mp.progetto;

import java.util.ArrayList;

public class Streams {

	public Streams() {
		super();
	}

	public boolean containsName(final ArrayList<Game> list, final String gameName) {
		return list.stream().filter(o -> o.getName().equals(gameName)).findAny().isPresent();
	}

	public double priceOfGame(final ArrayList<Game> list, final String gameName) {
		return list.stream().filter(o -> o.getName().equals(gameName)).findAny().get().price;
	}

}