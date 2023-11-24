package edu.hw4;

import java.util.List;

public class Task18 {
    private Task18() {

    }

    public static Animal mostHeaviestFish(List<List<Animal>> arrayAnimals) {
        Animal heavyFish = null;
        int maxWeight = -1;
        for (List<Animal> array : arrayAnimals) {
            for (Animal animal : array) {
                if (animal.type() == Animal.Type.FISH && animal.weight() > maxWeight) {
                    maxWeight = animal.weight();
                    heavyFish = animal;
                }
            }
        }
        return  heavyFish;
    }
}
