package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Сортировка животных по весу от маленького к большому, берём всех животных")
    void task1() {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal animal2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal animal3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal animal4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        List<Animal> test = Task2.WeightSortAndGetFirstK(animals, animals.size());

        List<Animal> answer = new ArrayList<>();
        answer.add(animal1);
        answer.add(animal3);
        answer.add(animal4);
        answer.add(animal2);

        assertThat(answer).isEqualTo(test);
    }


    @Test
    @DisplayName("Сортировка животных по весу от маленького к большому, берём первых двух")
    void task2() {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal animal2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal animal3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal animal4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        List<Animal> test = Task2.WeightSortAndGetFirstK(animals, 2);

        List<Animal> answer = new ArrayList<>();
        answer.add(animal1);
        answer.add(animal3);

        assertThat(answer).isEqualTo(test);
    }

    @Test
    @DisplayName("Сортировка животных по весу от маленького к большому, пытаемся взять больше животных, чем есть в списке")
    void task3() {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal animal2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal animal3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal animal4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        List<Animal> test = Task2.WeightSortAndGetFirstK(animals, animals.size() + 100);

        List<Animal> answer = new ArrayList<>();
        answer.add(animal1);
        answer.add(animal3);
        answer.add(animal4);
        answer.add(animal2);

        assertThat(answer).isEqualTo(test);
    }


}
