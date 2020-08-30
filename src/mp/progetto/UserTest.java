package mp.progetto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	@Test
	public void testValuesAreAssigned() {
		// setup
		User primoUtente = new User.UserBuilder("john88", "John Wick").withAge(20).build();
		// verify
		assertThat(primoUtente.getId()).isEqualTo("john88");
		assertThat(primoUtente.getName()).isEqualTo("John Wick");
		assertThat(primoUtente.getAge()).isEqualTo(20);
	}

	@Test
	public void testAddGames() {
		// setup
		ArrayList<String> list = new ArrayList<>(Arrays.asList("Game1", "Game2"));
		User primoUtente = new User.UserBuilder("john88", "John").setGames(list).build();
		primoUtente.addGame("Game3");
		// verify
		assertThat(primoUtente.getGames()).containsExactlyInAnyOrder("Game1", "Game2", "Game3");
	}

	@Test
	public void testAddFakeGames() {
		User primoUtente = new User.UserBuilder("john88", "John").build();
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> primoUtente.addGame("Game5"));
		ArrayList<String> list = new ArrayList<>(Arrays.asList("Game1", "Game5"));
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new User.UserBuilder("frank32", "Franceso").setGames(list).build());
	}

	@Test
	public void discount() {
		private Discount shop;
		 @Before
		 public void setup() {
		 shop = new Shop(DiscountStrategyFactory.noDiscount());
		 }

	}
}
