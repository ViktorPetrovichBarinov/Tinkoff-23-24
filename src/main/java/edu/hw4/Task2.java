package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task2 {

    public static class WeightComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal animal1, Animal animal2) {
            return Integer.compare(animal1.weight(), animal2.weight());
        }
    }

    public static List<Animal> WeightSort(List<Animal> animals) {
        animals.sort(new Task2.WeightComparator());
        return animals;
    }

    public static List<Animal> WeightSortAndGetFirstK(List<Animal> animals, Integer K) {
        WeightSort(animals);
        return animals.subList(0, Math.min(K, animals.size()));
    }
}
