package com.bnp.PricingCalculator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BookDiscountCalculator {

    /**
     * Initial placeholder class to calculate total price.
     */
    public double calculateTotalPrice(List<String> books) {
        return books.size() * 50.0;
    }


    public static void main(String[] args) {


    }

}
