package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Подсчёт животных каждого вида")
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

        Animal cat1 = new Animal("Sharik", Animal.Type.CAT, Animal.Sex.M, 7, 60, 55, false);
        Animal cat2 = new Animal("Bobik", Animal.Type.CAT, Animal.Sex.M, 5, 50, 77, false);
        Animal cat3 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.M, 3, 100, 65, false);
        animals.add(cat1);
        animals.add(cat2);
        animals.add(cat3);

        Animal bird1 = new Animal("Sharik", Animal.Type.BIRD, Animal.Sex.M, 7, 60, 55, false);
        Animal bird2 = new Animal("Bobik", Animal.Type.BIRD, Animal.Sex.M, 5, 50, 77, false);
        Animal bird3 = new Animal("Sasha", Animal.Type.BIRD, Animal.Sex.M, 3, 100, 65, false);
        animals.add(bird1);
        animals.add(bird2);
        animals.add(bird3);

        Animal fish1 = new Animal("Sharik", Animal.Type.FISH, Animal.Sex.M, 7, 60, 55, false);
        Animal fish2 = new Animal("Bobik", Animal.Type.FISH, Animal.Sex.M, 5, 50, 77, false);
        animals.add(fish1);
        animals.add(fish2);

        Map<Animal.Type, Integer> answer = new HashMap<>();
        answer.put(Animal.Type.DOG, 4);
        answer.put(Animal.Type.CAT, 3);
        answer.put(Animal.Type.BIRD, 3);
        answer.put(Animal.Type.FISH, 2);
        answer.put(Animal.Type.SPIDER, 0);

        assertThat(answer).isEqualTo(Task3.countAnimalsByType(animals));
    }
}
