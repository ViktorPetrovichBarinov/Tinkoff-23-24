package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task11 {

    private static final int minHeight = 100;
    public static List<Animal> animalsListThatCanBiteAndHeightMoreThan100сm(List<Animal> animals) {
        ArrayList<Animal> answer = new ArrayList<>();
        for (Animal animal : animals) {
            if(animal.bites() && animal.height() > minHeight) {
                answer.add(animal);
            }
        }
        return answer;
    }
}
