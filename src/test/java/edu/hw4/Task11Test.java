package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task11Test {

    @Test
    @DisplayName("")
    void task1() {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 4, 60, 55, false);
        Animal animal2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 101, 77, true);
        Animal animal3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 4, 100, 65, false);
        Animal animal4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 200, 50, true);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        var test = Task11.animalsListThatCanBiteAndHeightMoreThan100Cm(animals);

        List<Animal> answer = new ArrayList<>();
        answer.add(animal2);
        answer.add(animal4);

        assertThat(answer).isEqualTo(test);
    }
}
