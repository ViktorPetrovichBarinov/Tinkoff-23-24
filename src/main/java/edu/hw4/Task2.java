package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    public static List<Animal> weightSort(List<Animal> animals) {
        animals.sort(new Task2.WeightComparator());
        return animals;
    }

    public static List<Animal> weightSortAndGetFirstK(List<Animal> animals, Integer k) {
        weightSort(animals);
        return animals.subList(0, Math.min(k, animals.size()));
    }

    public static class WeightComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal animal1, Animal animal2) {
            return Integer.compare(animal1.weight(), animal2.weight());
        }
    }
}
