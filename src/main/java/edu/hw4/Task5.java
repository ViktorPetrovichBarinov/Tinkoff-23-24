package edu.hw4;

import java.util.List;

public class Task5 {
    private Task5() {

    }

    public static Animal.Sex mostPopularGender(List<Animal> animals) {
        int maleCounter = 0;
        int femaleCounter = 0;
        for (Animal animal : animals) {
            if (animal.sex() == Animal.Sex.M) {
                maleCounter++;
            } else {
                femaleCounter++;
            }
        }
        if (maleCounter >= femaleCounter) {
            return Animal.Sex.M;
        } else {
            return Animal.Sex.F;
        }
    }

}
