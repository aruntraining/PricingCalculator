package com.bnp.PricingCalculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookDiscountCalculatorTests {

	@Test
	public void testEmptyBasket() {
		BookDiscountCalculator calc = new BookDiscountCalculator();
		assertEquals(0.0, calc.calculateTotalPrice(List.of()));
	}

}
