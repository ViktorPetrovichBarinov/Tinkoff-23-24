package edu.hw4;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Сортировка животных по росту от маленького к большому")
    void task1() {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, false);
        Animal animal2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 70, false);
        Animal animal3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal animal4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        Task1.heightSort(animals);

        List<Animal> answer = new ArrayList<>();
        answer.add(animal4);
        answer.add(animal2);
        answer.add(animal1);
        answer.add(animal3);

        assertThat(answer).isEqualTo(animals);
    }



}
