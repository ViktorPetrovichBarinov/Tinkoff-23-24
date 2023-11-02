package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task16 {
    private Task16() {

    }

    public static List<Animal> task16(List<Animal> animals) {
        animals.sort(Comparator
            .comparing(Animal::type)
            .thenComparing(Animal::sex)
            .thenComparing(Animal::name)
        );

        return animals;
    }
}
