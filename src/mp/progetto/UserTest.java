package mp.progetto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private static Shop shop;

	@Before
	public void setup() {
		shop = new Shop();
		shop.addDefaultGames(shop);
	}

	@Test
	public void testValuesAreAssigned() {
		Game game1 = new Game("Spider", 0);
		// setup
		User primoUtente = new User.UserBuilder("john88", "John Wick").withAge(20).setGames(game1).build();
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
		list.add(new Game("Klondike", 0.0));
		list.add(new Game("Spider", 0.0));
		User primoUtente = new User.UserBuilder("john88", "John").setGames(list).build();

		primoUtente.addGame("Freecell", Shop.getGameList());
		// verify
		assertThat(primoUtente.containsName(primoUtente.getGames(), "Spider"));
		assertThat(primoUtente.containsName(primoUtente.getGames(), "Freecell"));
		assertThat(!primoUtente.containsName(primoUtente.getGames(), "Pyramid"));
	}

	@Test
	public void testAddFakeGames() {
		// setup
		ArrayList<Game> list = new ArrayList<Game>();
		list.add(new Game("Klondike", 0.0));
		list.add(new Game("Spider", 0.0));
		User primoUtente = new User.UserBuilder("john88", "John").setGames(list).build();
		// verify
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> primoUtente.addGame("Pyramid", Shop.getGameList()));
	}

}
