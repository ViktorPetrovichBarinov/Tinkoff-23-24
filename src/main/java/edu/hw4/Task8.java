package edu.hw4;

import java.util.List;
import java.util.Optional;

public class Task8 {

    public static Optional<Animal> MostHeaviestAnimalBelowK(List<Animal> animals, Integer K) {
        Animal answer = null;
        for (Animal animal : animals) {
            if (animal.height() < K) {
                if(answer == null) {
                    answer = animal;
                } else {
                    answer = (animal.weight() > answer.weight()) ? animal : answer;
                }
            }
        }
        return Optional.ofNullable(answer);
    }
}
