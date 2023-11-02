package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {

    @Test
    @DisplayName("Найти самую тяжелую рыбку в 2-х или более списках -> Animal")
    void task1() {
        List<Animal> animals1 = new ArrayList<>();
        Animal dog1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, true);
        Animal dog2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.F, 5, 50, 77, true);
        Animal dog3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, 3, 100, 65, true);
        Animal dog4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals1.add(dog1);
        animals1.add(dog2);
        animals1.add(dog3);
        animals1.add(dog4);

        Animal cat1 = new Animal("Sharik", Animal.Type.CAT, Animal.Sex.F, 7, 60, 33, false);
        Animal cat2 = new Animal("Bobik", Animal.Type.CAT, Animal.Sex.F, 5, 50, 22, false);
        Animal cat3 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 3, 100, 98, false);
        animals1.add(cat1);
        animals1.add(cat2);
        animals1.add(cat3);

        Animal bird1 = new Animal("Sharik", Animal.Type.BIRD, Animal.Sex.F, 7, 60, 12, false);
        Animal bird2 = new Animal("Bobik", Animal.Type.BIRD, Animal.Sex.F, 5, 50, 10, false);
        Animal bird3 = new Animal("Sasha", Animal.Type.BIRD, Animal.Sex.M, 3, 100, 6, false);
        animals1.add(bird1);
        animals1.add(bird2);
        animals1.add(bird3);

        Animal fish1 = new Animal("Sharik", Animal.Type.FISH, Animal.Sex.M, 7, 60, 9, false);
        Animal fish2 = new Animal("Bobik", Animal.Type.FISH, Animal.Sex.F, 5, 50, 3, false);
        animals1.add(fish1);
        animals1.add(fish2);

        Animal spider1 = new Animal("Sharik", Animal.Type.SPIDER, Animal.Sex.M, 7, 10, 1, true);
        Animal spider2 = new Animal("Bobik", Animal.Type.SPIDER, Animal.Sex.M, 5, 5, 2, true);
        animals1.add(spider1);
        animals1.add(spider2);


        List<Animal> animals2 = new ArrayList<>();
        dog1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 60, 55, true);
        dog2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.F, 5, 50, 77, true);
        dog3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, 3, 100, 65, true);
        dog4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals2.add(dog1);
        animals2.add(dog2);
        animals2.add(dog3);
        animals2.add(dog4);

        cat1 = new Animal("Sharik", Animal.Type.CAT, Animal.Sex.F, 7, 60, 33, false);
        cat2 = new Animal("Bobik", Animal.Type.CAT, Animal.Sex.F, 5, 50, 22, false);
        cat3 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 3, 100, 98, false);
        animals2.add(cat1);
        animals2.add(cat2);
        animals2.add(cat3);

        bird1 = new Animal("Sharik", Animal.Type.BIRD, Animal.Sex.F, 7, 60, 12, false);
        bird2 = new Animal("Bobik", Animal.Type.BIRD, Animal.Sex.F, 5, 50, 10, false);
        bird3 = new Animal("Sasha", Animal.Type.BIRD, Animal.Sex.M, 3, 100, 6, false);
        animals2.add(bird1);
        animals2.add(bird2);
        animals2.add(bird3);

        fish1 = new Animal("Sharik", Animal.Type.FISH, Animal.Sex.M, 7, 100, 100, false);
        fish2 = new Animal("Bobik", Animal.Type.FISH, Animal.Sex.F, 5, 50, 3, false);
        animals2.add(fish1);
        animals2.add(fish2);

        spider1 = new Animal("Sharik", Animal.Type.SPIDER, Animal.Sex.M, 7, 10, 1, true);
        spider2 = new Animal("Bobik", Animal.Type.SPIDER, Animal.Sex.M, 5, 5, 2, true);
        animals2.add(spider1);
        animals2.add(spider2);

        List<List<Animal>> arrayAnimals = new ArrayList<>();
        arrayAnimals.add(animals1);
        arrayAnimals.add(animals2);

        assertThat(fish1).isEqualTo(Task18.MostHeaviestFish(arrayAnimals));
    }


}
