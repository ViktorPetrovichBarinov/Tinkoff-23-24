package edu.hw4;

import java.util.List;

public class Task14 {

    public static Boolean isAnimalHigherThanKcm (List<Animal> animals, Integer K) {
        for (Animal animal : animals) {
            if (animal.height() > K) {
                return true;
            }
        }
        return false;
    }
}
