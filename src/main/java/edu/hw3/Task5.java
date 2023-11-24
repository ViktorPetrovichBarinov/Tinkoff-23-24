package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Task5 {
    private Task5() {

    }

    public enum Order {
        ASC,
        DESC
    }

    public static List<Person> parseContacs(String[] inputArray, Enum order) {
        if (inputArray == null || inputArray.length == 0) {
            return new ArrayList<>();
        }
        if (order == null) {
            throw new IllegalArgumentException("Incorrect order argument");
        }
        ArrayList<Person> personsWithSurname = new ArrayList<>();
        ArrayList<Person> personsWithoutSurname = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            String[] person = inputArray[i].split(" ");
            if (person.length > 2) {
                throw new IllegalArgumentException("Incorrect record");
            }
            if (person.length == 2) {
                personsWithSurname.add(new Person(person[0], person[1], true));
            }
            if (person.length == 1) {
                personsWithoutSurname.add(new Person(person[0], "NaN", false));
            }
        }
        if (order == Order.ASC) {
            Collections.sort(personsWithSurname);
            Collections.sort(personsWithoutSurname);
            personsWithSurname.addAll(personsWithoutSurname);
            return personsWithSurname;
        } else {
            Collections.sort(personsWithSurname, Collections.reverseOrder());
            Collections.sort(personsWithoutSurname, Collections.reverseOrder());
            personsWithoutSurname.addAll(personsWithSurname);
            return personsWithoutSurname;
        }
    }

    public record Person(String name, String surname, boolean isHaveSurname) implements Comparable<Person> {
        @Override
        public int compareTo(@NotNull Task5.Person person) {
            if (!this.isHaveSurname) {
                return this.name.compareTo(person.name);
            } else {
                int result = this.surname.compareTo(person.surname);
                if (result == 0) {
                    return this.name.compareTo(person.name);
                }
                return result;
            }
        }
    }
}
