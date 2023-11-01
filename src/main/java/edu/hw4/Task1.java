package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task1 {


    public static class HeightComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal animal1, Animal animal2) {
            return Integer.compare(animal1.height(), animal2.height());
        }
    }

    public static List<Animal> heightSort(List<Animal> animals) {
        animals.sort(new HeightComparator());
        return animals;
    }


}
