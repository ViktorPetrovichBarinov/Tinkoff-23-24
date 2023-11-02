package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @Test
    @DisplayName("Самое тяжелое животное ниже 1000")
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

        Optional<Animal> test = Task8.mostHeaviestAnimalBelowK(animals, 1000);

        assertThat(dog2).isEqualTo(test.get());
    }

    @Test
    @DisplayName("Самое тяжелое животное ниже 50")
    void task2() {
        List<Animal> animals = new ArrayList<>();
        Animal dog1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 35, 55, false);
        Animal dog2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal dog3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal dog4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(dog4);

        Optional<Animal> test = Task8.mostHeaviestAnimalBelowK(animals, 50);

        assertThat(dog4).isEqualTo(test.get());
    }

    @Test
    @DisplayName("Самое тяжелое животное ниже 10")
    void task3() {
        List<Animal> animals = new ArrayList<>();
        Animal dog1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 35, 55, false);
        Animal dog2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal dog3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal dog4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(dog4);

        Optional<Animal> test = Task8.mostHeaviestAnimalBelowK(animals, 10);

        assertThat(test.isPresent()).isFalse();
    }


}
