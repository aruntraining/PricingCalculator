package com.bnp.bookpricingcalculator.service;

import java.util.*;

import static com.bnp.bookpricingcalculator.constants.BookPricingConstants.BOOK_PRICE;
import static com.bnp.bookpricingcalculator.constants.BookPricingConstants.DISCOUNTS;

public class BookPricingCalculator {

    /**
     * Initial placeholder class to calculate total price.
     */
    public double calculateTotalPrice(List<String> books) {
        Map<String, Integer> bookCounts = new HashMap<>();
        for (String book : books) {
            bookCounts.put(book, bookCounts.getOrDefault(book, 0) + 1);
        }

        List<Integer> groupSizes = new ArrayList<>();

        while (bookCounts.values().stream().anyMatch(count  -> count > 0)) {
            Set<String> currentSet = new HashSet<>();
            for (String book : bookCounts.keySet()) {
                if (bookCounts.get(book) > 0) {
                    currentSet.add(book);
                    bookCounts.put(book, bookCounts.get(book) - 1);
                }
            }
            groupSizes.add(currentSet.size());
        }

        double totalPrice = 0.0;
        for (int size : groupSizes) {
            totalPrice += size * BOOK_PRICE * (1 - DISCOUNTS.get(size));
        }
        return totalPrice;
    }
}
