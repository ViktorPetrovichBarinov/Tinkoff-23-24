package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("0-ое самое тяжелое животное")
    void task1() {
        List<Animal> animals = new ArrayList<>();
        Animal dog1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal dog2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal dog3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal dog4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(dog4);

        Animal test = Task7.KthMostOldAnimal(animals, 0);

        assertThat(dog1).isEqualTo(test);
    }

    @Test
    @DisplayName("2-ое самое тяжелое животное")
    void task2() {
        List<Animal> animals = new ArrayList<>();
        Animal dog1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal dog2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal dog3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal dog4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(dog4);

        Animal test = Task7.KthMostOldAnimal(animals, 2);

        assertThat(dog3).isEqualTo(test);
    }

    @Test
    @DisplayName("100-ое самое тяжелое животное")
    void task3() {
        List<Animal> animals = new ArrayList<>();
        Animal dog1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal dog2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal dog3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal dog4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(dog4);

        Animal test = Task7.KthMostOldAnimal(animals, 100);

        assertThat(dog4).isEqualTo(test);
    }
}
