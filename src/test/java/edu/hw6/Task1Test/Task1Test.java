package edu.hw6.Task1Test;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("size test")
    void test1() {
        String fileName = "src/test/java/edu/hw6/Task1Test/testFile1.txt";
        DiskMap diskMap = new DiskMap(fileName);

        Integer answer = 3;

        assertThat(answer).isEqualTo(diskMap.size());



        diskMap.put("key4", "str4");

        answer = 4;

        assertThat(answer).isEqualTo(diskMap.size());
        assertThat("str4").isEqualTo(diskMap.get("key4"));



        diskMap.remove("key4");
    }



    @Test
    @DisplayName("isEmpty remove")
    void test2() {
        String fileName = "src/test/java/edu/hw6/Task1Test/testFile2.txt";
        DiskMap diskMap = new DiskMap(fileName);

        assertThat(diskMap.isEmpty()).isTrue();


        diskMap.put("key1", "str1");

        assertThat(diskMap.containsKey("key1")).isTrue();
        assertThat(diskMap.containsValue("str1")).isTrue();
        assertThat(diskMap.remove("key1")).isEqualTo("str1");
    }


    @Test
    @DisplayName("isEmpty clear")
    void test3() {
        String fileName = "src/test/java/edu/hw6/Task1Test/testFile3.txt";
        DiskMap diskMap = new DiskMap(fileName);

        assertThat(diskMap.isEmpty()).isTrue();


        diskMap.put("key1", "str1");

        assertThat(diskMap.containsKey("key1")).isTrue();
        assertThat(diskMap.containsValue("str1")).isTrue();



        diskMap.clear();

        assertThat(diskMap.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("putAll")
    void test4() {
        String fileName = "src/test/java/edu/hw6/Task1Test/testFile4.txt";
        DiskMap diskMap = new DiskMap(fileName);

        assertThat(diskMap.isEmpty()).isTrue();



        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "str1");
        hashMap.put("key2", "str2");

        diskMap.putAll(hashMap);

        assertThat(2).isEqualTo(diskMap.size());



        Set<String> keySet = new HashSet<>();
        keySet.add("key1");
        keySet.add("key2");

        assertThat(keySet).isEqualTo(diskMap.keySet());



        Collection<String> values = diskMap.values();
        String expectedValue1 = "str1";
        String expectedValue2 = "str2";

        assertThat(values.contains(expectedValue1)).isTrue();
        assertThat(values.contains(expectedValue2)).isTrue();
        assertThat(2).isEqualTo(values.size());



        Set<Map.Entry<String, String>> entrySet = diskMap.entrySet();

        // Ожидаемые значения
        String expectedKey1 = "key1";
        expectedValue1 = "str1";
        String expectedKey2 = "key2";
        expectedValue2 = "str2";

        assertThat(entrySet.contains(Map.entry(expectedKey1, expectedValue1))).isTrue();
        assertThat(entrySet.contains(Map.entry(expectedKey2, expectedValue2))).isTrue();

        diskMap.clear();
    }
}
