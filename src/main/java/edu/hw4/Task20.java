package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task20 {

    public static class ValidationError {
        private final String error;
        private final String field;

        public ValidationError(String error, String field) {
            this.error = error;
            this.field = field;
        }

        public String getError() {
            return error;
        }

        public String getField() {
            return field;
        }
    }


    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();

        if (animal.age() <= 0) {
            errors.add(new ValidationError("Возраст должен быть больше 0", "age"));
        }

        if (animal.weight() <= 0) {
            errors.add(new ValidationError("Вес должен быть больше 0", "weight"));
        }

        if (animal.height() <= 0) {
            errors.add(new ValidationError("Рост должен быть больше 0", "height"));
        }

        return errors;
    }

    public static Map<String, String> getAnimalsWithErrors(List<Animal> animals) {
        Map<String, String> animalsWithErrors = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> errors = validateAnimal(animal);

            if (!errors.isEmpty()) {
                StringBuilder errorMessage = new StringBuilder();
                for (ValidationError error : errors) {
                    errorMessage.append(error.getField()).append(": ").append(error.getError()).append("; ");
                }
                animalsWithErrors.put(animal.name(), errorMessage.toString());
            }
        }

        return animalsWithErrors;
    }


}
