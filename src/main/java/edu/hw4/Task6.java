package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {

    public static Map<Animal.Type, Animal> heaviestAnimalEveryType (List<Animal> animals) {
        HashMap<Animal.Type, Animal> tableOfSeverity = new HashMap<>();

        tableOfSeverity.put(Animal.Type.CAT, null);
        tableOfSeverity.put(Animal.Type.DOG, null);
        tableOfSeverity.put(Animal.Type.BIRD, null);
        tableOfSeverity.put(Animal.Type.FISH, null);
        tableOfSeverity.put(Animal.Type.SPIDER, null);

        for (Animal animal : animals) {
            if(tableOfSeverity.get(animal.type()) == null) {
                tableOfSeverity.put(animal.type(), animal);
            } else {
                int currentAnimalWeight = tableOfSeverity.get(animal.type()).weight();
                if (currentAnimalWeight < animal.weight()) {
                    tableOfSeverity.put(animal.type(), animal);
                }
            }
        }
        return tableOfSeverity;
    }
}
