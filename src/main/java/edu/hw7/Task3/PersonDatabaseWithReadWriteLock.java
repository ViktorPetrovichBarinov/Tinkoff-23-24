package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.NotNull;

public class PersonDatabaseWithReadWriteLock implements PersonDatabase {

    private final HashMap<Integer, Person> personHashMapId = new HashMap<>();
    private final HashMap<String, List<Person>> personHashMapName = new HashMap<>();
    private final HashMap<String, List<Person>> personHashMapAddress = new HashMap<>();
    private final HashMap<String, List<Person>> personHashMapPhone = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(@NotNull Person person) {
        lock.writeLock().lock();

        try {
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
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public void delete(int id) {
        if (!personHashMapId.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        lock.writeLock().lock();

        try {
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
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public List<Person> findByName(@NotNull String name) {
        lock.readLock().lock();
        try {
            if (personHashMapName.containsKey(name)) {
                return personHashMapName.get(name);
            }
            return null;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(@NotNull String address) {
        lock.readLock().lock();
        try {
            if (personHashMapAddress.containsKey(address)) {
                return personHashMapAddress.get(address);
            }
            return null;
        } finally {
            lock.readLock().unlock();
        }

    }

    @Override
    public List<Person> findByPhone(@NotNull String phone) {
        lock.readLock().lock();
        try {
            if (personHashMapPhone.containsKey(phone)) {
                return personHashMapPhone.get(phone);
            }
            return null;
        } finally {
            lock.readLock().unlock();
        }

    }
}
