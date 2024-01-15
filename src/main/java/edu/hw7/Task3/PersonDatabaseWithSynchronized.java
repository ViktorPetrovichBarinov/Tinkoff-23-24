package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class PersonDatabaseWithSynchronized implements PersonDatabase {
    private final HashMap<Integer, Person> personHashMapId = new HashMap<>();
    private final HashMap<String, List<Person>> personHashMapName = new HashMap<>();
    private final HashMap<String, List<Person>> personHashMapAddress = new HashMap<>();
    private final HashMap<String, List<Person>> personHashMapPhone = new HashMap<>();

    @Override
    public synchronized void add(@NotNull Person person) {
        personHashMapId.put(person.id(), person);
        String name = person.name();
        String address = person.address();
        String phone = person.phoneNumber();

        ArrayList<Person> listOfPersonsByName;
        if (personHashMapName.containsKey(name)) {
            listOfPersonsByName = (ArrayList<Person>) personHashMapName.get(name);
        } else {
            listOfPersonsByName = new ArrayList<>();
        }
        listOfPersonsByName.add(person);
        personHashMapName.put(name, listOfPersonsByName);


        ArrayList<Person> listOfPersonsByAddress;
        if (personHashMapAddress.containsKey(address)) {
            listOfPersonsByAddress = (ArrayList<Person>) personHashMapAddress.get(address);
        } else {
            listOfPersonsByAddress = new ArrayList<>();
        }
        listOfPersonsByAddress.add(person);
        personHashMapAddress.put(address, listOfPersonsByAddress);


        ArrayList<Person> listOfPersonsByPhone;
        if (personHashMapPhone.containsKey(phone)) {
            listOfPersonsByPhone = (ArrayList<Person>) personHashMapPhone.get(phone);
        } else {
            listOfPersonsByPhone = new ArrayList<>();
        }
        listOfPersonsByPhone.add(person);
        personHashMapPhone.put(phone, listOfPersonsByPhone);
    }

    @Override
    public synchronized void delete(int id) {
        if (!personHashMapId.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        Person person = personHashMapId.get(id);
        String name = person.name();
        String address = person.address();
        String phone = person.phoneNumber();


        personHashMapId.remove(id);

        ArrayList<Person> personListByName = (ArrayList<Person>) personHashMapName.get(name);
        personListByName.remove(person);
        if (personListByName.isEmpty()) {
            personHashMapName.remove(name);
        } else {
            personHashMapName.put(name, personListByName);
        }


        ArrayList<Person> personListByAddress = (ArrayList<Person>) personHashMapAddress.get(address);
        personListByAddress.remove(person);
        if (personListByAddress.isEmpty()) {
            personHashMapAddress.remove(address);
        } else {
            personHashMapAddress.put(address, personListByAddress);
        }

        ArrayList<Person> personListByPhone = (ArrayList<Person>) personHashMapPhone.get(phone);
        personListByPhone.remove(person);
        personHashMapPhone.put(phone, personListByPhone);
        if (personListByPhone.isEmpty()) {
            personHashMapPhone.remove(phone);
        } else {
            personHashMapPhone.put(phone, personListByPhone);
        }
    }

    @Override
    public synchronized List<Person> findByName(@NotNull String name) {
        if (personHashMapName.containsKey(name)) {
            return personHashMapName.get(name);
        }
        return null;
    }

    @Override
    public synchronized List<Person> findByAddress(@NotNull String address) {
        if (personHashMapAddress.containsKey(address)) {
            return personHashMapAddress.get(address);
        }
        return null;
    }

    @Override
    public synchronized List<Person> findByPhone(@NotNull String phone) {
        if (personHashMapPhone.containsKey(phone)) {
            return personHashMapPhone.get(phone);
        }
        return null;
    }
}
