package com.bnp.bookpricingcalculator.service;

import com.bnp.bookpricingcalculator.Validation.BookValidator;
import com.bnp.bookpricingcalculator.constants.BookPricingConstants;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.bnp.bookpricingcalculator.constants.BookPricingConstants.BOOK_PRICE;
import static com.bnp.bookpricingcalculator.constants.BookPricingConstants.DISCOUNTS;

/**
 * BookDiscountCalculator calculates total price using group discounts
 * for sets of unique programming books.
 * <p>
 * Discounts:
 * - 2 books: 5%
 * - 3 books: 10%
 * - 4 books: 20%
 * - 5 books: 25%
 */
public class BookPricingCalculator {

    /**
     * Initial placeholder class to calculate total price.
     */
    public double calculateTotalPrice(List<String> books) {

        // Delegate validation
        BookValidator.validate(books);

        // Calculate thr Book count By grouping
        try {
            Map<String, Integer> bookCounts = books.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.groupingBy(Function.identity(),
                            Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

            List<Integer> bookGroupSizes = new ArrayList<>();

            while (bookCounts.values().stream().anyMatch(count -> count > 0)) {
                Set<String> currentSet = new HashSet<>();
                for (String book : bookCounts.keySet()) {
                    if (bookCounts.get(book) > 0) {
                        currentSet.add(book);
                        bookCounts.put(book, bookCounts.get(book) - 1);
                    }
                }
                bookGroupSizes.add(currentSet.size());
            }

            optimizeGroups(bookGroupSizes);

            double totalPrice = 0.0;
            for (int size : bookGroupSizes) {
                totalPrice += size * BookPricingConstants.BOOK_PRICE * (1 - BookPricingConstants.DISCOUNTS.getOrDefault(size, 0.0));
            }
            return totalPrice;

        } catch (Exception e) {
            // Log or rethrow as needed
            throw new RuntimeException("Error calculating book price: " + e.getMessage(), e);
        }
    }

    // Adjust group sizes for better discount combinations
    private void optimizeGroups(List<Integer> groupSizes) {
        while (groupSizes.contains(5) && groupSizes.contains(3)) {
            groupSizes.remove(Integer.valueOf(5));
            groupSizes.remove(Integer.valueOf(3));
            groupSizes.add(4);
            groupSizes.add(4);
        }
    }
}
