package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task10 {
    private Task10() {

    }

    public static List<Animal> listOfAnimalsPawsNotEqualAges(List<Animal> animals) {
        ArrayList<Animal> returnList = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.paws() != animal.age()) {
                returnList.add(animal);
            }
        }
        return returnList;
    }
}
