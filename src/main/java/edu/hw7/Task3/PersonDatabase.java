package edu.hw7.Task3;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface PersonDatabase {
    void add(@NotNull Person person);

    void delete(int id);

    List<Person> findByName(@NotNull String name);

    List<Person> findByAddress(@NotNull String address);

    List<Person> findByPhone(@NotNull String phone);
}
