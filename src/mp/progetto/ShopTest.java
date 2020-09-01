package mp.progetto;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class ShopTest {
	private Shop shop;

	@Before
	public void setup() {
		shop = new Shop(DiscountStrategyFactoryLambda.noDiscount());
		shop.addDefaultGames(shop);
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
}
