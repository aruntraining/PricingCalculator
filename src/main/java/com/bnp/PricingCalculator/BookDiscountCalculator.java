package com.bnp.PricingCalculator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class BookDiscountCalculator {

    private static final double BOOK_PRICE = 50.0;
    private static final Map<Integer, Double> DISCOUNTS = Map.of(
            1, 0.0,
            2, 0.05,
            3, 0.10,
            4, 0.20,
            5, 0.25
    );

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


    public static void main(String[] args) {


    }

}
