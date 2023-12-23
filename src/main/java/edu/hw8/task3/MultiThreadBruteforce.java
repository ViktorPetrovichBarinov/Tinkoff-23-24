package edu.hw8.task3;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import static edu.hw8.task3.DataReader.readFromFile;
import static edu.hw8.task3.GenerateHash.hashGenerate;

public class MultiThreadBruteforce {
    private static String filePath = null;
    private static HashMap<String, String> data = null;
    private static ConcurrentHashMap<String, String> passwords = null;
    private static String allLetters = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    public MultiThreadBruteforce(String path) {
        filePath = path;
        data = readFromFile(filePath);
        passwords = new ConcurrentHashMap<>();
    }

    public void passwordFindInit(String currentPassword, int remainingLength, int threadNumber) {
        Thread[] threads = new Thread[threadNumber];
        int chunkSize = allLetters.length() / threadNumber;


        for (int i = 0; i < threadNumber; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == threadNumber - 1) ? remainingLength : (i + 1) * chunkSize;

            threads[i] = new Thread(() -> {
                for (int j = startIndex; j < endIndex; j++) {
                    passwordFind(currentPassword + allLetters.charAt(j), remainingLength - 1);
                }
            }
            );
        }

        for (int i = 0; i < threadNumber; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threadNumber; i++) {
           try {
               threads[i].join();
           } catch (InterruptedException e) {

           }
        }

    }

    public void passwordFind(String currentPassword, int remainingLength) {
        if (remainingLength == 0) {
            String hash = hashGenerate(currentPassword);
            if (data.containsKey(hash)) {
                //System.out.println(currentPassword + " " + data.get(hash));
                passwords.put(data.get(hash), currentPassword);
            }

        } else {
            for (int i = 0; i < allLetters.length(); i++) {
                passwordFind(currentPassword + allLetters.charAt(i), remainingLength - 1);
            }
        }
    }

    public static ConcurrentHashMap<String, String> getPasswords() {
        return passwords;
    }
}
