package edu.hw7.Task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Проверка, что возвращает корректные списки")
    void test1() {
        PersonDatabaseWithSynchronized dataBase = new PersonDatabaseWithSynchronized();

        Person person1 = new Person(1, "Ruslan", "Zavodskaya 98", "111");
        dataBase.add(person1);
        Person person2 = new Person(2, "Viktor", "Zavodskaya 99", "222");
        dataBase.add(person2);
        Person person3 = new Person(3, "Ruslan", "Zavodskaya 100", "333");
        dataBase.add(person3);
        Person person4 = new Person(4, "Olesya", "Zavodskaya 98", "444");
        dataBase.add(person4);
        Person person5 = new Person(5, "Ruslan2", "Zavodskaya 98", "111");
        dataBase.add(person5);

        ArrayList<Person> arrayByName = new ArrayList<>();
        arrayByName.add(person1);
        arrayByName.add(person3);
        assertThat(arrayByName).isEqualTo(dataBase.findByName("Ruslan"));


        ArrayList<Person> arrayByAddress = new ArrayList<>();
        arrayByAddress.add(person1);
        arrayByAddress.add(person4);
        arrayByAddress.add(person5);
        assertThat(arrayByAddress).isEqualTo(dataBase.findByAddress("Zavodskaya 98"));


        ArrayList<Person> arrayByPhone = new ArrayList<>();
        arrayByPhone.add(person1);
        arrayByPhone.add(person5);
        assertThat(arrayByPhone).isEqualTo(dataBase.findByPhone("111"));
    }

    @Test
    @DisplayName("Проверка, что нормально работает удаление записей")
    void test2() {
        PersonDatabaseWithSynchronized dataBase = new PersonDatabaseWithSynchronized();

        Person person1 = new Person(1, "Ruslan", "Zavodskaya 98", "111");
        dataBase.add(person1);
        Person person2 = new Person(2, "Viktor", "Zavodskaya 99", "222");
        dataBase.add(person2);
        Person person3 = new Person(3, "Ruslan", "Zavodskaya 100", "333");
        dataBase.add(person3);
        Person person4 = new Person(4, "Olesya", "Zavodskaya 98", "444");
        dataBase.add(person4);
        Person person5 = new Person(5, "Ruslan2", "Zavodskaya 98", "111");
        dataBase.add(person5);

        dataBase.delete(5);
        dataBase.delete(1);


        ArrayList<Person> arrayByName = new ArrayList<>();
        arrayByName.add(person3);
        assertThat(arrayByName).isEqualTo(dataBase.findByName("Ruslan"));


        ArrayList<Person> arrayByAddress = new ArrayList<>();
        arrayByAddress.add(person4);
        assertThat(arrayByAddress).isEqualTo(dataBase.findByAddress("Zavodskaya 98"));


        assertThat(dataBase.findByPhone("111")).isNull();
    }


    @Test
    @DisplayName("Попытка параллельной записи")
    void test3() {
        PersonDatabaseWithSynchronized dataBase = new PersonDatabaseWithSynchronized();

        Person person1 = new Person(1, "Ruslan", "Zavodskaya 98", "111");
        Person person2 = new Person(2, "Viktor", "Zavodskaya 99", "222");
        Person person3 = new Person(3, "Ruslan", "Zavodskaya 100", "333");
        Person person4 = new Person(4, "Olesya", "Zavodskaya 98", "444");
        Person person5 = new Person(5, "Ruslan2", "Zavodskaya 98", "111");


        Thread firstThread = new Thread(() -> {
            dataBase.add(person1);
            dataBase.add(person2);
            dataBase.delete(1);
        });
        Thread secondThread = new Thread(() -> {
            dataBase.add(person3);
            dataBase.add(person4);
            dataBase.add(person5);
            dataBase.delete(5);
        });
        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            System.exit(-1);
        }



        ArrayList<Person> arrayByName = new ArrayList<>();
        arrayByName.add(person3);
        assertThat(arrayByName).isEqualTo(dataBase.findByName("Ruslan"));


        ArrayList<Person> arrayByAddress = new ArrayList<>();
        arrayByAddress.add(person4);
        assertThat(arrayByAddress).isEqualTo(dataBase.findByAddress("Zavodskaya 98"));


        assertThat(dataBase.findByPhone("111")).isNull();
    }

    @Test
    @DisplayName("Параллельное чтение и запись ")
    void test4() {
        PersonDatabaseWithReadWriteLock dataBase = new PersonDatabaseWithReadWriteLock();

        Person person1 = new Person(1, "Ruslan", "Zavodskaya 98", "111");
        Person person2 = new Person(2, "Viktor", "Zavodskaya 99", "222");
        Person person3 = new Person(3, "Ruslan", "Zavodskaya 100", "333");
        Person person4 = new Person(4, "Olesya", "Zavodskaya 98", "444");
        Person person5 = new Person(5, "Ruslan2", "Zavodskaya 98", "111");


        Thread firstWriteThread = new Thread(() -> {
            dataBase.add(person1);
            dataBase.add(person2);
            dataBase.delete(1);
        });
        Thread secondWriteThread = new Thread(() -> {
            dataBase.add(person3);
            dataBase.add(person4);
            dataBase.add(person5);
            dataBase.delete(5);
        });
        firstWriteThread.start();
        secondWriteThread.start();

        try {
            firstWriteThread.join();
            secondWriteThread.join();
        } catch (InterruptedException e) {
            System.exit(-1);
        }

        Thread firstReadThread = new Thread(() -> {
            ArrayList<Person> arrayByName = new ArrayList<>();
            arrayByName.add(person3);
            assertThat(arrayByName).isEqualTo(dataBase.findByName("Ruslan"));
        });

        Thread secondReadThread = new Thread(() -> {
            ArrayList<Person> arrayByAddress = new ArrayList<>();
            arrayByAddress.add(person4);
            assertThat(arrayByAddress).isEqualTo(dataBase.findByAddress("Zavodskaya 98"));
        });

        Thread thirdReadThread = new Thread(() -> {
            assertThat(dataBase.findByPhone("111")).isNull();
        });

        firstReadThread.start();
        secondReadThread.start();
        thirdReadThread.start();

        try {
            firstReadThread.join();
            secondReadThread.join();
            thirdReadThread.join();
        } catch (InterruptedException e) {
            System.exit(-1);
        }

    }
}
