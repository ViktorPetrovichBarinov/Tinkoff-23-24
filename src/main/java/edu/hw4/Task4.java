package edu.hw4;

import java.util.List;

public class Task4 {

    public static Animal MostLongestName(List<Animal> animals) {
        int maxNameLength = -1;
        Animal animalWithMostLongestName = null;
        for (Animal animal : animals) {
            int currentAnimalNameLength = animal.name().length();
            if (currentAnimalNameLength > maxNameLength) {
                maxNameLength = currentAnimalNameLength;
                animalWithMostLongestName = animal;
            }
        }
        return animalWithMostLongestName;
    }
}
