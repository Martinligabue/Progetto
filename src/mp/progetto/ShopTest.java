package mp.progetto;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class ShopTest extends Streams {
	private Shop shop;

	@Before
	public void setup() {
		shop = new Shop(DiscountStrategyFactoryLambda.noDiscount());
		shop.addDefaultGames();
	}

	@After
	public void clean() {
		shop.clean();
	}

	@Test
	public void testDefaultStrategy() {
		assertEquals(10, shop.getTotal(10), 0);
	}

	@Test
	public void testAbsoluteDiscountStrategy() {
		shop.setDiscountStrategy(DiscountStrategyFactoryLambda.coupon(3));
		assertEquals(7, shop.getTotal(10), 0);
	}

	@Test
	public void testPercentageDiscountStrategy() {
		shop.setDiscountStrategy(DiscountStrategyFactoryLambda.summerSale());
		assertEquals(80, shop.getTotal(100), 0);
	}

	@Test
	public void testFriendDiscountStrategy() {
		shop.setDiscountStrategy(DiscountStrategyFactoryLambda.friendDiscount(3));
		assertEquals(70, shop.getTotal(100), 0);
	}

	@Test
	public void testUser() {
		Game game1 = new Game("Spider", priceOfGame(shop.getGameList(), "Spider"));
		User primoUtente = new User.UserBuilder("john88", "John Wick").withFriends(3)
				.setGames(game1, shop.getGameList()).build();
		shop.setDiscountStrategy(DiscountStrategyFactoryLambda.friendDiscount(primoUtente.getFriends()));
		assertEquals(7, shop.getTotal(primoUtente.getExactGame("Spider").price), 0);
	}
}
