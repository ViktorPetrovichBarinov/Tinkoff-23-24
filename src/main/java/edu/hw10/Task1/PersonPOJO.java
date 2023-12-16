package edu.hw10.Task1;

public class PersonPOJO {
    private int age;
    private double salary;
    private boolean isMarried;
    private char favoriteLetter;
    private String favoriteQuote;

    public PersonPOJO(@RandomObjectGenerator.Max(10) @RandomObjectGenerator.Min(-10) int age,
        double salary,
        boolean isMarried,
        char favoriteLetter,
        String favoriteQuote) {
        this.age = age;
        this.salary = salary;
        this.isMarried = isMarried;
        this.favoriteLetter = favoriteLetter;
        this.favoriteQuote = favoriteQuote;
    }

    public static PersonPOJO create(
        @RandomObjectGenerator.Max(10)
        @RandomObjectGenerator.Min(-10)
        int age,
        double salary,
        boolean isMarried,
        char favoriteLetter,
        String favoriteQuote) {
        return new PersonPOJO(age, salary, isMarried, favoriteLetter, favoriteQuote);
    }

    @Override
    public String toString() {
        return "Age: " + age + "\n"
                + "Salary: " + salary + "\n"
                + "isMarried: " + isMarried + "\n"
                + "favoriteLetter: " + favoriteLetter + "\n"
                + "favoriteQuote: " + favoriteQuote + "\n";
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public char getFavoriteLetter() {
        return favoriteLetter;
    }

    public String getFavoriteQuote() {
        return favoriteQuote;
    }
}
