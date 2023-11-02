package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task11 {
    private Task11() {

    }

    private static final int MIN_HEIGHT = 100;

    public static List<Animal> animalsListThatCanBiteAndHeightMoreThan100Cm(List<Animal> animals) {
        ArrayList<Animal> answer = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.bites() && animal.height() > MIN_HEIGHT) {
                answer.add(animal);
            }
        }
        return answer;
    }
}
