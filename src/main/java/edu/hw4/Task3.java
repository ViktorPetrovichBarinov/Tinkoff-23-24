package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    public static Map<Animal.Type, Integer> countAnimalsByType(List<Animal> animals) {
        Map<Animal.Type, Integer> CountingTable = new HashMap<>();
        CountingTable.put(Animal.Type.CAT, 0);
        CountingTable.put(Animal.Type.DOG, 0);
        CountingTable.put(Animal.Type.BIRD, 0);
        CountingTable.put(Animal.Type.FISH, 0);
        CountingTable.put(Animal.Type.SPIDER, 0);


        for(Animal animal : animals) {
            int currentTypeCounter = CountingTable.get(animal.type());
            CountingTable.put(animal.type(), currentTypeCounter + 1);
        }
        return CountingTable;
    }
}
