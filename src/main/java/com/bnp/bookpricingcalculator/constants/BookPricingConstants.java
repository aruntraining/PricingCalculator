package com.bnp.bookpricingcalculator.constants;

import java.util.Map;

public class BookPricingConstants {

    public static final double BOOK_PRICE = 50.0;
    public static final Map<Integer, Double> DISCOUNTS = Map.of(
            1, 0.0,
            2, 0.05,
            3, 0.10,
            4, 0.20,
            5, 0.25
    );
}
