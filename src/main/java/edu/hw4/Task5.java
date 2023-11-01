package edu.hw4;

import java.util.List;

public class Task5 {

    public static Animal.Sex mostPopularGender(List<Animal> animals) {
        int MaleCounter = 0;
        int FemaleCounter = 0;
        for(Animal animal : animals) {
            if (animal.sex() == Animal.Sex.M) {
                MaleCounter++;
            } else {
                FemaleCounter++;
            }
        }
        if(MaleCounter >= FemaleCounter) {
            return Animal.Sex.M;
        } else {
            return Animal.Sex.F;
        }
    }

}
