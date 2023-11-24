package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task7 {
    private Task7() {

    }

    public static List<Animal> ageReverseSort(List<Animal> animals) {
        animals.sort(new Task7.AgeComparator().reversed());
        return animals;
    }

    public static Animal kthMostOldAnimal(List<Animal> animals, Integer k) {
        ageReverseSort(animals);
        if (k <= animals.size()) {
            return animals.get(k);
        } else {
            return animals.getLast();
        }

    }

    public static class AgeComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal animal1, Animal animal2) {
            return Integer.compare(animal1.age(), animal2.age());
        }
    }
}
