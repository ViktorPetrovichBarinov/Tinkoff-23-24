package edu.hw4;

import java.util.List;

public class Task9 {
    private Task9() {

    }

    public static Integer summuryNumberOfPaws(List<Animal> animals) {
        int answer = 0;
        for (Animal animal : animals) {
            answer += animal.paws();
        }
        return answer;
    }
}
