package edu.hw4;

import java.util.List;

public class Task17 {
    private Task17() {

    }

    public static Boolean isTrueThatSpidersMoreOftenThanDogs(List<Animal> animals) {
        int dogsBite = 0;
        int spiderBite = 0;
        for (Animal animal : animals) {
            if (animal.type() == Animal.Type.DOG && animal.bites()) {
                dogsBite++;
            }
            if (animal.type() == Animal.Type.SPIDER && animal.bites()) {
                spiderBite++;
            }
        }
        return spiderBite > dogsBite;
    }
}
