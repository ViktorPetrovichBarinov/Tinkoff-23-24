package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task19 {

    public static class ValidationError {
        private final String error;

        public ValidationError(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }

    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();

        if (animal.age() <= 0) {
            errors.add(new ValidationError("Возраст должен быть больше 0"));
        }

        if (animal.weight() <= 0) {
            errors.add(new ValidationError("Вес должен быть больше 0"));
        }

        if (animal.height() <= 0) {
            errors.add(new ValidationError("Рост должен быть больше 0"));
        }

        return errors;
    }

    public static Map<String, Set<ValidationError>> getAnimalsWithErrors(List<Animal> animals) {
        Map<String, Set<ValidationError>> animalsWithErrors = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> errors = validateAnimal(animal);

            if (!errors.isEmpty()) {
                animalsWithErrors.put(animal.name(), errors);
            }
        }

        return animalsWithErrors;
    }

}
