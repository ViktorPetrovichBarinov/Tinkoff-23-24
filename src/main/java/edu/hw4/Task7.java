package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task7 {

    public static class AgeComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal animal1, Animal animal2) {
            return Integer.compare(animal1.age(), animal2.age());
        }
    }

    public static List<Animal> ageReverseSort(List<Animal> animals) {
        animals.sort(new Task7.AgeComparator().reversed());
        return animals;
    }

    public static Animal KthMostOldAnimal(List<Animal> animals, Integer K) {
        ageReverseSort(animals);
        if(K <= animals.size()) {
            return animals.get(K);
        } else {
            return animals.getLast();
        }

    }


}
