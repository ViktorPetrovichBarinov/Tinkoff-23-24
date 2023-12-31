package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task15 {
    private Task15() {

    }

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        HashMap<Animal.Type, Integer> answer = new HashMap<>();
        answer.put(Animal.Type.CAT, 0);
        answer.put(Animal.Type.DOG, 0);
        answer.put(Animal.Type.BIRD, 0);
        answer.put(Animal.Type.FISH, 0);
        answer.put(Animal.Type.SPIDER, 0);

        for (Animal animal : animals) {
            if (animal.age() > k && animal.age() < l) {
                int currentWeight = answer.get(animal.type());
                answer.put(animal.type(), currentWeight + animal.weight());
            }
        }
        return  answer;
    }
}
