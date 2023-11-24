package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Самцов больше")
    void task1() {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal animal2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal animal3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal animal4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.F, 1, 30, 70, false);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        Animal.Sex MostPopularGender = Task5.mostPopularGender(animals);

        Animal.Sex answer = Animal.Sex.M;
        assertThat(answer).isEqualTo(MostPopularGender);
    }


    @Test
    @DisplayName("Самцов и самок одинаково")
    void task2() {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal animal2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal animal3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, 3, 100, 65, false);
        Animal animal4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.F, 1, 30, 70, false);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        Animal.Sex MostPopularGender = Task5.mostPopularGender(animals);

        Animal.Sex answer = Animal.Sex.M;
        assertThat(answer).isEqualTo(MostPopularGender);
    }

    @Test
    @DisplayName("Самок больше")
    void task3() {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal animal2 = new Animal("Bobikessa", Animal.Type.DOG, Animal.Sex.F, 5, 50, 77, false);
        Animal animal3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, 3, 100, 65, false);
        Animal animal4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.F, 1, 30, 70, false);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        Animal.Sex MostPopularGender = Task5.mostPopularGender(animals);

        Animal.Sex answer = Animal.Sex.F;
        assertThat(answer).isEqualTo(MostPopularGender);
    }

}
