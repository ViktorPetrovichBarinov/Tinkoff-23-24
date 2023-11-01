package edu.hw4;

import java.util.List;

public class Task9 {

    public static Integer SummuryNumberOfPaws(List<Animal> animals) {
        Integer answer = 0;
        for(Animal animal : animals) {
            answer += animal.paws();
        }
        return answer;
    }
}
