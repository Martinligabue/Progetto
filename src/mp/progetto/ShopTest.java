package mp.progetto;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class ShopTest {/*
	private Shop shop;

	@Before
	public void setup() {
		shop = new Shop(new NoDiscountStrategy());	
	}

	@Test
	public void testDefaultStrategy() {
		assertEquals(10, shop.getTotal(10));
	}

	@Test
	public void testAbsoluteDiscountStrategy() {
		shop.setDiscountStrategy(new AbsoluteDiscountStrategy(3));
		assertEquals(7, shop.getTotal(10));
	}

	@Test
	public void testPercentageDiscountStrategy() {
		shop.setDiscountStrategy(new PercentageDiscountStrategy(15));
		assertEquals(85, shop.getTotal(100));
	}
	*/
	
	
	private Shop shop;

	@Before
	public void setup() {
		shop = new Shop(DiscountStrategyFactory.noDiscount());
	}

	@Test
	public void testDefaultStrategy() {
		assertEquals(10, shop.getTotal(10));
	}

	@Test
	public void testAbsoluteDiscountStrategy() {
		shop.setDiscountStrategy(DiscountStrategyFactory.absoluteDiscount(3));
		assertEquals(7, shop.getTotal(10));
	}

	@Test
	public void testPercentageDiscountStrategy() {
		shop.setDiscountStrategy(DiscountStrategyFactory.percentageDiscount(15));
		assertEquals(85, shop.getTotal(100));
	}

}
