package edu.hw8.Task3;

import javax.swing.JPasswordField;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import static edu.hw8.Task3.DataReader.readFromFile;
import static edu.hw8.Task3.GenerateHash.hashGenerate;

public class SingleThreadBruteforce implements Bruteforcer{
    private static String FILE_PATH = null;
    private static HashMap<String, String> data = null;
    private static HashMap<String, String> passwords = null;

    public SingleThreadBruteforce(String path) {
        FILE_PATH = path;
        data = readFromFile(FILE_PATH);
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
            for (int i = 0; i <= 9; i++) {
                passwordFind(currentPassword + i, remainingLength - 1);
            }
            for (int i = 0; i < 26; i++) {
                passwordFind(currentPassword + (char)('a' + i), remainingLength - 1);
                passwordFind(currentPassword + (char)('A' + i), remainingLength - 1);
            }
        }
    }

    public static HashMap<String, String> getPasswords() {
        return passwords;
    }

}
