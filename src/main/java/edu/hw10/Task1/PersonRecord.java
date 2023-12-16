package edu.hw10.Task1;

public record PersonRecord(
    @RandomObjectGenerator.Max(10) @RandomObjectGenerator.Min(-10)int age,
    double salary,
    boolean isMarried,
    char favoriteLetter,
    String favoriteQuote) {
}
