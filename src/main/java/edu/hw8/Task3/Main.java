package edu.hw8.Task3;

import java.util.HashMap;
import static edu.hw8.Task3.DataReader.readFromFile;


public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = readFromFile("src/main/java/edu/hw8/Task3/data.txt");
    }
}
