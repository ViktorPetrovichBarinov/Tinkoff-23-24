package edu.hw8.task3;

import java.util.HashMap;
import static edu.hw8.task3.DataReader.readFromFile;
import static edu.hw8.task3.GenerateHash.hashGenerate;

public class SingleThreadBruteforce implements Bruteforcer {
    private static String filePath = null;
    private static HashMap<String, String> data = null;
    private static HashMap<String, String> passwords = null;
    private static final int NUMBER_OF_NUMBERS = 10;
    private static final int NUMBER_OF_LETTERS = 26;


    public SingleThreadBruteforce(String path) {
        filePath = path;
        data = readFromFile(filePath);
        passwords = new HashMap<>();
    }



    public void passwordFind(String currentPassword, int remainingLength) {
        if (remainingLength == 0) {
            String hash = hashGenerate(currentPassword);
            if (data.containsKey(hash)) {
                //System.out.println(currentPassword + " " + data.get(hash));
                passwords.put(data.get(hash), currentPassword);
            }

        } else {
            // Генерируем пароли рекурсивно для каждой цифры от 0 до 9
            for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
                passwordFind(currentPassword + i, remainingLength - 1);
            }
            for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
                passwordFind(currentPassword + (char) ('a' + i), remainingLength - 1);
                passwordFind(currentPassword + (char) ('A' + i), remainingLength - 1);
            }
        }
    }

    public static HashMap<String, String> getPasswords() {
        return passwords;
    }

}
