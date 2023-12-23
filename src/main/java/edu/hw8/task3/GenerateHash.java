package edu.hw8.task3;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenerateHash {
    private GenerateHash() {}

    public static String hashGenerate(String password) {
        try {
            // Получаем экземпляр MessageDigest с использованием алгоритма MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Преобразуем пароль в массив байтов и обновляем MessageDigest
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            md.update(passwordBytes);

            // Вычисляем MD5-хэш
            byte[] hashBytes = md.digest();

            // Преобразуем байты хэша в строку в шестнадцатеричном формате
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                hexStringBuilder.append(String.format("%02x", b));
            }

            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
