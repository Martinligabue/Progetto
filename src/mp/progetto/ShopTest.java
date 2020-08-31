package mp.progetto;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class ShopTest {
	private Shop shop;

	@Before
	public void setup() {
		shop = new Shop(DiscountStrategyFactory.noDiscount());
		shop.addGame("Klondike", 0);
		shop.addGame("Klondike", 10);
		shop.addGame("Klondike", 50);
		shop.addGame("Klondike", 15.5);
	}

	@Test
	public void testDefaultStrategy() {
		assertEquals(10, shop.getTotal(10), 0);
	}

	@Test
	public void testAbsoluteDiscountStrategy() {
		shop.setDiscountStrategy(DiscountStrategyFactory.coupon(3));
		assertEquals(7, shop.getTotal(10), 0);
	}

	@Test
	public void testPercentageDiscountStrategy() {
		shop.setDiscountStrategy(DiscountStrategyFactory.summerSale());
		assertEquals(80, shop.getTotal(100), 0);
	}

	@Test
	public void testFriendDiscountStrategy() {
		shop.setDiscountStrategy(DiscountStrategyFactory.friendDiscount(3));
		assertEquals(70, shop.getTotal(100), 0);
	}
}
