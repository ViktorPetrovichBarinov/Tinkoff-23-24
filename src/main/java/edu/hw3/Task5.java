package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Task5 {
    public enum Order {
        ASC,
        DESC
    }

    public static Comparator<Person> personComparator = new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2) {
            if(!person1.isHaveSurname) {
                return person1.name.compareTo(person2.name);
            } else {
                int result = person1.surname.compareTo(person2.surname);
                if (result == 0) {
                    return person1.name.compareTo(person2.name);
                }
                return result;
            }
        }
    };

    public static ArrayList<Person> parseContacs(String[] inputArray, Enum order) {
        if (inputArray == null || inputArray.length == 0) {
            return new ArrayList<>();
        }
        if(order == null) {
            throw new IllegalArgumentException("Incorrect order argument");
        }
        ArrayList<Person> personsWithSurname = new ArrayList<>();
        ArrayList<Person> personsWithoutSurname = new ArrayList<>();
        for (int i = 0;i < inputArray.length; i++) {
            String[] person = inputArray[i].split(" ");
            if(person.length > 2) {
                throw new IllegalArgumentException("Incorrect record");
            }
            if(person.length == 2) {
                personsWithSurname.add(new Person(person[0], person[1], true));
            }
            if(person.length == 1) {
                personsWithoutSurname.add(new Person(person[0], "NaN", false));
            }
        }
        if(order == Order.ASC) {
            Collections.sort(personsWithSurname, personComparator);
            Collections.sort(personsWithoutSurname, personComparator);
            personsWithSurname.addAll(personsWithoutSurname);
            return personsWithSurname;
        } else {
            Collections.sort(personsWithSurname, personComparator.reversed());
            Collections.sort(personsWithoutSurname, personComparator.reversed());
            personsWithoutSurname.addAll(personsWithSurname);
            return personsWithoutSurname;
        }
    }

    public record Person(String name, String surname, boolean isHaveSurname) {}

}


