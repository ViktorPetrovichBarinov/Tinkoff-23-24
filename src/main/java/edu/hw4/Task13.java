package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task13 {

    public static List<Animal> ListOfAnimalsWithComplexName(List<Animal> animals) {
        ArrayList<Animal> answer = new ArrayList<>();
        for (Animal animal : animals) {
            String[] parseName = animal.name().split(" ");
            if (parseName.length >= 2) {
                answer.add(animal);
            }
        }
        return answer;
    }
}
