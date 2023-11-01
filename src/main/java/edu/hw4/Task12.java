package edu.hw4;

import java.util.List;

public class Task12 {

    public static Integer NumberOfAnimalsThatWeightMoreThenHeight(List<Animal> animals) {
        Integer answer = 0;
        for (Animal animal : animals) {
            if(animal.weight() > animal.height()) {
                answer++;
            }
        }
        return answer;
    }
}
