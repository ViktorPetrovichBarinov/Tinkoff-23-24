package edu.hw10;

import edu.hw10.Task1.PersonPOJO;
import edu.hw10.Task1.PersonRecord;
import edu.hw10.Task1.RandomObjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    private final static double EPSILON = 0.01;
    private boolean isEqual(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }


    @Test
    @DisplayName("POJO constructor")
    void test1() {
        Random random = new Random(100);
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator(random);
        PersonPOJO personPOJO = randomObjectGenerator.nextObject(PersonPOJO.class);

        int age = -6;
        double salary = -61.004;
        boolean isMarried = true;
        char favoriteLetter = 'e';
        String favoriteQuote = "bPrhAjQuhGQDrYExETSFAgaHgetqCdJkftmNwRjQgElhIABt";

        assertThat(personPOJO.getAge()).isEqualTo(age);
        assertThat(isEqual(personPOJO.getSalary(), salary)).isTrue();
        assertThat(personPOJO.isMarried()).isEqualTo(isMarried);
        assertThat(personPOJO.getFavoriteLetter()).isEqualTo(favoriteLetter);
        assertThat(personPOJO.getFavoriteQuote()).isEqualTo(favoriteQuote);
    }

    @Test
    @DisplayName("POJO fabric")
    void test2() {
        Random random = new Random(100);
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator(random);
        PersonPOJO personPOJO = randomObjectGenerator.nextObject(PersonPOJO.class, "create");

        int age = -6;
        double salary = -61.004;
        boolean isMarried = true;
        char favoriteLetter = 'e';
        String favoriteQuote = "bPrhAjQuhGQDrYExETSFAgaHgetqCdJkftmNwRjQgElhIABt";

        assertThat(personPOJO.getAge()).isEqualTo(age);
        assertThat(isEqual(personPOJO.getSalary(), salary)).isTrue();
        assertThat(personPOJO.isMarried()).isEqualTo(isMarried);
        assertThat(personPOJO.getFavoriteLetter()).isEqualTo(favoriteLetter);
        assertThat(personPOJO.getFavoriteQuote()).isEqualTo(favoriteQuote);
    }

    @Test
    @DisplayName("record")
    void test3() {
        Random random = new Random(100);
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator(random);
        PersonRecord personPOJO = randomObjectGenerator.nextObject(PersonRecord.class);

        int age = -6;
        double salary = -61.004;
        boolean isMarried = true;
        char favoriteLetter = 'e';
        String favoriteQuote = "bPrhAjQuhGQDrYExETSFAgaHgetqCdJkftmNwRjQgElhIABt";

        assertThat(personPOJO.age()).isEqualTo(age);
        assertThat(isEqual(personPOJO.salary(), salary)).isTrue();
        assertThat(personPOJO.isMarried()).isEqualTo(isMarried);
        assertThat(personPOJO.favoriteLetter()).isEqualTo(favoriteLetter);
        assertThat(personPOJO.favoriteQuote()).isEqualTo(favoriteQuote);
    }


    @Test
    @DisplayName("Проверка работы аннотаций")
    void test5() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator(random);
            PersonPOJO personPOJO = randomObjectGenerator.nextObject(PersonPOJO.class);

            assertThat(personPOJO.getAge() < 10 && personPOJO.getAge() > -10).isTrue();
        }
    }
}
