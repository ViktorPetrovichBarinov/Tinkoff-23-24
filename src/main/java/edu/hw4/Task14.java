package edu.hw4;

import java.util.List;

public class Task14 {
    private Task14() {

    }

    public static Boolean isAnimalHigherThanKcm(List<Animal> animals, Integer k) {
        for (Animal animal : animals) {
            if (animal.height() > k) {
                return true;
            }
        }
        return false;
    }
}
