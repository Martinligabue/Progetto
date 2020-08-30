package mp.progetto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
public class ShopTest {

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

}
