package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task19Test {

    @Test
    @DisplayName("Животные, в записях о которых есть ошибки: вернуть имя и список ошибок -> Map<String, Set<ValidationError>>.")
    void task1() {
        List<Animal> animals = new ArrayList<>();
        Animal dog1 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, -1, 46, 77, true);
        Animal dog2 = new Animal("Bobik", Animal.Type.DOG, Animal.Sex.F, 5, -1, 77, true);
        Animal dog3 = new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, 3, 100, -1, true);
        Animal dog4 = new Animal("Tiffany", Animal.Type.DOG, Animal.Sex.M, 1, 30, 70, false);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(dog4);



        Map<String, Set<Task19.ValidationError>> actualErrors = Task19.getAnimalsWithErrors(animals);

        var error = new Task19.ValidationError("Возраст должен быть больше 0");
        assertThat(error.getError()).isEqualTo(actualErrors.get("Sharik").iterator().next().getError());


        error = new Task19.ValidationError("Рост должен быть больше 0");
        assertThat(error.getError()).isEqualTo(actualErrors.get("Bobik").iterator().next().getError());

        error = new Task19.ValidationError("Вес должен быть больше 0");
        assertThat(error.getError()).isEqualTo(actualErrors.get("Sasha").iterator().next().getError());
    }


}
