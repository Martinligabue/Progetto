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
	public void testDiscountStrategy() {
		shop.setDiscountStrategy(DiscountStrategyFactoryLambda.coupon(3));
		assertEquals(7, shop.getTotal(10), 0);
		shop.setDiscountStrategy(DiscountStrategyFactoryLambda.summerSale());
		assertEquals(80, shop.getTotal(100), 0);
		shop.setDiscountStrategy(DiscountStrategyFactoryLambda.friendDiscount(3));
		assertEquals(70, shop.getTotal(100), 0);
	}

	@Test
	public void testDiscountOnUser() {//solo con variabili
		String gameNameString="Spider";
		String usernameString="john88";
		String nameString="John Wick";
		int friendsInt=3;
		
		Game game1 = new Game(gameNameString, priceOfGame(shop.getGameList(), gameNameString));
		User primoUtente = new User.UserBuilder(usernameString, nameString).withFriends(friendsInt)
				.setGames(game1, shop.getGameList()).build();
		shop.setDiscountStrategy(DiscountStrategyFactoryLambda.friendDiscount(primoUtente.getFriends()));
		assertEquals(7, shop.getTotal(primoUtente.getExactGame("Spider").price), 0);
	}
}
