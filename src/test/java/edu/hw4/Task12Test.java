package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task12Test {

    @Test
    @DisplayName("Сколько в списке животных, вес которых превышает рост -> Integer")
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

        Integer test = Task12.NumberOfAnimalsThatWeightMoreThenHeight(animals);

        Integer answer = 2;

        assertThat(answer).isEqualTo(test);
    }


}
