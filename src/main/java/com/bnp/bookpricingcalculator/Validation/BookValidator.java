package com.bnp.bookpricingcalculator.Validation;

import com.bnp.bookpricingcalculator.constants.BookPricingConstants;

import java.util.List;

public class BookValidator {

    public static void validate(List<String> books) {
        if (books == null) {
            throw new IllegalArgumentException("Book list cannot be null.");
        }

        books.stream()
                .filter(book -> !BookPricingConstants.VALID_BOOKS.contains(book))
                .findFirst()
                .ifPresent(book -> {
                    throw new IllegalArgumentException("Invalid book title: Not A Real Book:");
                });
    }
}
