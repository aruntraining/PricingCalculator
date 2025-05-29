package com.bnp.bookpricingcalculator;

import com.bnp.bookpricingcalculator.service.BookPricingCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookPricingCalculatorTests {

	private final BookPricingCalculator calc = new BookPricingCalculator();
	@Test
	public void testEmptyBasket() {
		assertEquals(0.0, calc.calculateTotalPrice(List.of()));
	}

	@Test
	public void testSingleBook() {
		assertEquals(50.0, calc.calculateTotalPrice(List.of("Clean Code")));
	}

	@Test
	public void testTwoDifferentBooks() {
		List<String> books = List.of("Clean Code", "The Clean Coder"); // 5% discount
		assertEquals(95.0, calc.calculateTotalPrice(books), 0.01);
	}

	@Test
	public void testThreeDifferentBooks() {
		List<String> books = List.of("Clean Code", "The Clean Coder", "Clean Architecture");
		double expected = 3 * 50 * 0.90; // 10% discount
		assertEquals(expected, calc.calculateTotalPrice(books),0.01);
	}

	@Test
	public void testFiveDifferentBooks() {
		List<String> books = List.of(
				"Clean Code", "The Clean Coder", "Clean Architecture",
				"Test Driven Development by Example", "Working Effectively With Legacy Code"
		);
		double expected = 5 * 50 * 0.75;
		assertEquals(expected, calc.calculateTotalPrice(books), 0.01);
	}

	@Test
	public void testComplexBasketWithOptimization() {
		List<String> books = List.of(
				"Clean Code", "Clean Code",
				"The Clean Coder", "The Clean Coder",
				"Clean Architecture", "Clean Architecture",
				"Test Driven Development by Example",
				"Working Effectively With Legacy Code"
		);
		assertEquals(320.0, calc.calculateTotalPrice(books), 0.01);
	}


}
