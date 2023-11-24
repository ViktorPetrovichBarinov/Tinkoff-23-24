package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task9Test {

    @Test
    @DisplayName("Кол-во лап 4 собак")
    void task1() {
        List<Animal> animals = new ArrayList<>();
        Animal dog1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 35, 55, false);
        Animal dog2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 5, 50, 77, false);
        Animal dog3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.M, 3, 100, 65, false);
        Animal dog4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(dog4);

        Integer test = Task9.summuryNumberOfPaws(animals);

        Integer answer = 16;

        assertThat(answer).isEqualTo(test);
    }

    @Test
    @DisplayName("Кол-во лап 3 котов")
    void task2() {
        List<Animal> animals = new ArrayList<>();
        Animal cat1 = new Animal("Sharik", Animal.Type.CAT, Animal.Sex.M, 7, 60, 55, false);
        Animal cat2 = new Animal("Bobik", Animal.Type.CAT, Animal.Sex.M, 5, 50, 77, false);
        Animal cat3 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.M, 3, 100, 65, false);
        animals.add(cat1);
        animals.add(cat2);
        animals.add(cat3);
        Integer test = Task9.summuryNumberOfPaws(animals);

        Integer answer = 12;

        assertThat(answer).isEqualTo(test);
    }

    @Test
    @DisplayName("Кол-во лап 3 птиц")
    void task3() {
        List<Animal> animals = new ArrayList<>();
        Animal bird1 = new Animal("Sharik", Animal.Type.BIRD, Animal.Sex.M, 7, 60, 55, false);
        Animal bird2 = new Animal("Bobik", Animal.Type.BIRD, Animal.Sex.M, 5, 50, 77, false);
        Animal bird3 = new Animal("Sasha", Animal.Type.BIRD, Animal.Sex.M, 3, 100, 65, false);
        animals.add(bird1);
        animals.add(bird2);
        animals.add(bird3);

        Integer test = Task9.summuryNumberOfPaws(animals);

        Integer answer = 6;

        assertThat(answer).isEqualTo(test);
    }

    @Test
    @DisplayName("Кол-во лап 2 рыб")
    void task4() {
        List<Animal> animals = new ArrayList<>();
        Animal fish1 = new Animal("Sharik", Animal.Type.FISH, Animal.Sex.M, 7, 60, 55, false);
        Animal fish2 = new Animal("Bobik", Animal.Type.FISH, Animal.Sex.M, 5, 50, 77, false);
        animals.add(fish1);
        animals.add(fish2);

        Integer test = Task9.summuryNumberOfPaws(animals);

        Integer answer = 0;

        assertThat(answer).isEqualTo(test);
    }

    @Test
    @DisplayName("Кол-во лап 2 пауков")
    void task5() {
        List<Animal> animals = new ArrayList<>();
        Animal spider1 = new Animal("Альфред", Animal.Type.SPIDER, Animal.Sex.M, 7, 60, 55, false);
        Animal spider2 = new Animal("Фрэнк", Animal.Type.SPIDER, Animal.Sex.M, 5, 50, 77, false);
        animals.add(spider1);
        animals.add(spider2);

        Integer test = Task9.summuryNumberOfPaws(animals);

        Integer answer = 16;

        assertThat(answer).isEqualTo(test);
    }
}
