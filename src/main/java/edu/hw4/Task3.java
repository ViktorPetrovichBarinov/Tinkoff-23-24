package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    private Task3() {

    }

    public static Map<Animal.Type, Integer> countAnimalsByType(List<Animal> animals) {
        Map<Animal.Type, Integer> countingTable = new HashMap<>();
        countingTable.put(Animal.Type.CAT, 0);
        countingTable.put(Animal.Type.DOG, 0);
        countingTable.put(Animal.Type.BIRD, 0);
        countingTable.put(Animal.Type.FISH, 0);
        countingTable.put(Animal.Type.SPIDER, 0);


        for (Animal animal : animals) {
            int currentTypeCounter = countingTable.get(animal.type());
            countingTable.put(animal.type(), currentTypeCounter + 1);
        }
        return countingTable;
    }
}
