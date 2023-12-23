package edu.hw8;

import edu.hw8.task3.MultiThreadBruteforce;
import edu.hw8.task3.SingleThreadBruteforce;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Один поток")
    void test1() {
        SingleThreadBruteforce bf = new SingleThreadBruteforce("src/main/java/edu/hw8/task3/data.txt");
        for (int i = 1; i <= 4; i++){
            bf.passwordFind("", i);
        }

        HashMap<String, String> passwords = SingleThreadBruteforce.getPasswords();

        assertThat(passwords.containsKey("a.v.petrov")).isTrue();
        assertThat(passwords.get("a.v.petrov")).isEqualTo("1234");
        assertThat(passwords.containsKey("v.v.belov")).isTrue();
        assertThat(passwords.get("v.v.belov")).isEqualTo("4321");
        assertThat(passwords.containsKey("a.s.ivanov")).isTrue();
        assertThat(passwords.get("a.s.ivanov")).isEqualTo("123");
        assertThat(passwords.containsKey("k.p.maslov")).isTrue();
        assertThat(passwords.get("k.p.maslov")).isEqualTo("321");
    }

    @Test
    @DisplayName("4 потока")
    void test2() {
        MultiThreadBruteforce bf = new MultiThreadBruteforce("src/main/java/edu/hw8/task3/data.txt");
        for (int i = 1; i <= 4; i++){
            bf.passwordFindInit("", i, 2);
        }

        ConcurrentHashMap<String, String> passwords = MultiThreadBruteforce.getPasswords();

        assertThat(passwords.containsKey("a.v.petrov")).isTrue();
        assertThat(passwords.get("a.v.petrov")).isEqualTo("1234");
        assertThat(passwords.containsKey("v.v.belov")).isTrue();
        assertThat(passwords.get("v.v.belov")).isEqualTo("4321");
        assertThat(passwords.containsKey("a.s.ivanov")).isTrue();
        assertThat(passwords.get("a.s.ivanov")).isEqualTo("123");
        assertThat(passwords.containsKey("k.p.maslov")).isTrue();
        assertThat(passwords.get("k.p.maslov")).isEqualTo("321");
    }
}
