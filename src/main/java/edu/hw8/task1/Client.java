package edu.hw8.task1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static final String LOCALHOST = "localhost";

    private final int portNumber;

    public Client(int portNumber) {
        this.portNumber = portNumber;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void userStartUse() {
        try {
            Socket socket = new Socket(LOCALHOST, portNumber);

            // Запрашиваем у пользователя ввод строки
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите строку для отправки на сервер: ");
            String userInput = scanner.nextLine();

            sendRequest(socket, userInput);

            System.out.println("Отправлено на сервер: " + userInput);
            System.out.println("Ожидаем ответа от сервера: ");

            ArrayList<String> receivedData = (ArrayList<String>) getAnswer(socket);

            if (receivedData == null) {
                System.out.println("Фраз по заданному слову не найдено(((");
            } else {
                System.out.println("Вот список фраз:");
                for (String quote:receivedData) {
                    System.out.println("  *" + quote);
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<String> userStartUseTest(String sendData) {
        try {
            Socket socket = new Socket(LOCALHOST, portNumber);

            sendRequest(socket, sendData);

            ArrayList<String> receivedData = (ArrayList<String>) getAnswer(socket);

            socket.close();

            return receivedData;
        } catch (IOException e) {
            return null;
        }
    }


    public static void sendRequest(Socket socket, String data) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            out.println(data);
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    public static List<String> getAnswer(Socket socket) {
        ArrayList<String> receivedData = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            receivedData = (ArrayList<String>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.exit(-1);
        }
        return receivedData;
    }
}
