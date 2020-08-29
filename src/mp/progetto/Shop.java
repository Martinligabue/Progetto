package mp.progetto;

import java.util.ArrayList;
import java.util.Arrays;

public class Shop {// manage games and users, manages also usernames/ids univocity, 
	static ArrayList<String> gameList = new ArrayList<>(Arrays.asList("Game1", "Game2", "Game3", "Game4"));

	public static ArrayList<String> getGameList() {
		return gameList;
	}
	
}
