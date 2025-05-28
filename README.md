# Book Discount Kata 📚

This project calculates the total price of a basket of programming books based on discounts for sets of different titles.

## 💡 Problem Statement

There are 5 different books. You get a discount when you buy multiple **different** titles together:

- 2 different books: 5% discount
- 3 different books: 10% discount
- 4 different books: 20% discount
- 5 different books: 25% discount

Duplicate books get grouped optimally to maximize discounts.

## ✅ Features
- TDD using JUnit 5
- Maintainable, clean code

## 🧪 Run Main Program

Use an IDE or run from terminal:

```bash
mvn exec:java -Dexec.mainClass="com.bnp.bookpricingcalculator.BookDiscountCalculator"
```

## 🧪 Run Tests

```bash
mvn clean install
``
```bash
mvn test
```



