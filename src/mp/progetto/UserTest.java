package mp.progetto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest extends Streams {//aggiungere singolo gioco? aggiungere lista personalizzata?
	private static Shop shop;

	@Before
	public void setup() {
		shop = new Shop();
		shop.addDefaultGames();
	}

	@After
	public void clean() {
		shop.clean();
	}

	@Test
	public void testValuesAreAssigned() {
		Game game1 = new Game("Spider", priceOfGame(shop.getGameList(), "Spider"));
		User primoUtente = new User.UserBuilder("john88", "John Wick").withAge(20).setGames(game1, shop.getGameList())
				.build();
		// verify
		assertThat(primoUtente.getId()).isEqualTo("john88");
		assertThat(primoUtente.getName()).isEqualTo("John Wick");
		assertThat(primoUtente.getAge()).isEqualTo(20);
		assertThat(primoUtente.getGames().contains(game1));
	}

	@Test
	public void testAddGames() {
		// setup
		ArrayList<Game> list = new ArrayList<Game>();
		list.add(new Game("Klondike", priceOfGame(shop.getGameList(), "Klondike")));
		list.add(new Game("Spider", priceOfGame(shop.getGameList(), "Spider")));
		User primoUtente = new User.UserBuilder("john88", "John").setGames(list, shop.getGameList()).build();

		primoUtente.addGame("Freecell", shop.getGameList());
		// verify
		assertThat(primoUtente.containsName(primoUtente.getGames(), "Spider"));
		assertThat(primoUtente.containsName(primoUtente.getGames(), "Freecell"));
		assertThat(!primoUtente.containsName(primoUtente.getGames(), "Pyramid"));
	}

	@Test
	public void testAddFakeGames() {
		// setup
		ArrayList<Game> list = new ArrayList<Game>();
		list.add(new Game("Klondike", priceOfGame(shop.getGameList(), "Klondike")));
		list.add(new Game("Spider", priceOfGame(shop.getGameList(), "Spider")));
		User primoUtente = new User.UserBuilder("john88", "John").setGames(list, shop.getGameList()).build();
		// verify
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> primoUtente.addGame("Pyramid", shop.getGameList()));
	}

}
