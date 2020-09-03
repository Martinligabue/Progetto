package mp.progetto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest extends Streams {
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

		assertThat(primoUtente.getId()).isEqualTo("john88");
		assertThat(primoUtente.getName()).isEqualTo("John Wick");
		assertThat(primoUtente.getAge()).isEqualTo(20);
		assertThat(primoUtente.getGames().contains(game1));
	}

	@Test
	public void testCustomList() {
		shop.clean();
		Game game1 = new Game("Spider", 10.5);
		ArrayList<Game> list1 = new ArrayList<Game>();
		list1.add(game1);
		User primoUtente = new User.UserBuilder("john88", "John Wick").setGames(game1, list1).build();
		assertThat(primoUtente.getGames().contains(game1));
	}

	@Test
	public void testAddGames() {
		ArrayList<Game> list = new ArrayList<Game>();
		list.add(new Game("Klondike", priceOfGame(shop.getGameList(), "Klondike")));
		list.add(new Game("Spider", priceOfGame(shop.getGameList(), "Spider")));
		User primoUtente = new User.UserBuilder("john88", "John").setGames(list, shop.getGameList()).build();

		primoUtente.addGame("Freecell", shop.getGameList());

		assertThat(primoUtente.containsName(primoUtente.getGames(), "Spider"));
		assertThat(primoUtente.containsName(primoUtente.getGames(), "Freecell"));
		assertThat(!primoUtente.containsName(primoUtente.getGames(), "Pyramid"));

		User secondoUtente = new User.UserBuilder("bob", "Robert").setGames(new Game("Klondike", 0), shop.getGameList())
				.build();
		assertThat(secondoUtente.containsName(secondoUtente.getGames(), "Klondike"));

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
