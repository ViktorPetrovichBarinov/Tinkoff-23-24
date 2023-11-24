package edu.hw4;

import java.util.List;
import java.util.Optional;

public class Task8 {
    private Task8() {

    }

    public static Optional<Animal> mostHeaviestAnimalBelowK(List<Animal> animals, Integer k) {
        Animal answer = null;
        for (Animal animal : animals) {
            if (animal.height() < k) {
                if (answer == null) {
                    answer = animal;
                } else {
                    answer = (animal.weight() > answer.weight()) ? animal : answer;
                }
            }
        }
        return Optional.ofNullable(answer);
    }
}
